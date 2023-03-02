package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.MainServerConfiguration;
import app.project.FranchiseMicroservice.config.ThreadPoolTaskSchedulerConfig;
import app.project.FranchiseMicroservice.model.postgres.VentaDetalle;
import app.project.FranchiseMicroservice.modelMainServer.HistoricalReport;
import app.project.FranchiseMicroservice.modelMainServer.VentaDetalleOut;
import app.project.FranchiseMicroservice.repo.postgres.IVentaDetalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportsService {

    @Autowired
    private IVentaDetalleRepo ventaDetalleRepo;

    @Autowired
    private ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig;

    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    public List<VentaDetalle> get_history_report(Instant fecha1, Instant fecha2){
        String url = this.mainServerConfiguration.getUrl();
        String token = this.mainServerConfiguration.getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        List<VentaDetalleOut> reportes = new ArrayList<>();
        for (int i = 0; i < this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1,fecha2).size(); i++) {
            VentaDetalleOut ventaDetalleOut = new VentaDetalleOut();

            ventaDetalleOut.setVentaId(this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1,fecha2).get(i).getVenta().getVentaId());
            ventaDetalleOut.setFecha(this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1,fecha2).get(i).getVenta().getFecha());
            ventaDetalleOut.setMenu(this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1,fecha2).get(i).getMenu().getId());
            ventaDetalleOut.setPrecio(this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1,fecha2).get(i).getPrecio());

            reportes.add(ventaDetalleOut);
        }

        try {
            URI uri = new URI(url+"/api/reporte/datos");
            HistoricalReport report = new HistoricalReport("respuesta_reporte",reportes);
            HttpEntity<HistoricalReport> entity = new HttpEntity<>(report, headers);
            this.restTemplate.postForObject(uri, entity, HistoricalReport.class);
            System.out.println(this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1, fecha2));
            System.out.println("Reporte enviado");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.ventaDetalleRepo.findAllByVentaFechaBetween(fecha1, fecha2);
    }

    public void get_recurrent_report(Instant fecha1, Instant fecha2, String duration){
        RunnableReport runnableReport = new RunnableReport(fecha1, fecha2, ReportsService .this);
        Duration durationParse = Duration.parse(duration);
        threadPoolTaskSchedulerConfig.threadPoolTaskScheduler().scheduleAtFixedRate(runnableReport, fecha1, durationParse);
    }

    public void get_recurrent_report_cancel(){
        threadPoolTaskSchedulerConfig.threadPoolTaskScheduler().shutdown();
        System.out.println("Reporte cancelado");
    }
}
