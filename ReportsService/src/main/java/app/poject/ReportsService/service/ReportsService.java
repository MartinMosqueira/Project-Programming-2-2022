package app.poject.ReportsService.service;

import app.poject.ReportsService.client.ConsulClient;
import app.poject.ReportsService.config.MainServerConfiguration;
import app.poject.ReportsService.config.ThreadPoolTaskSchedulerConfig;
import app.poject.ReportsService.model.VentaDetalle;
import app.poject.ReportsService.modelMainServer.HistoricalReport;
import app.poject.ReportsService.modelMainServer.VentaDetalleOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReportsService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsulClient consulClient;

    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig;

    public List<VentaDetalle> get_history_report(Instant fecha1, Instant fecha2){
        String url = this.mainServerConfiguration.getUrl();
        String token = this.mainServerConfiguration.getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        List<VentaDetalleOut> reportes = new ArrayList<>();

        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        ResponseEntity<VentaDetalle[]> ventaDetalle =restTemplate.getForEntity(selectUri.resolve("/detalle/date/"+fecha1+"/"+fecha2), VentaDetalle[].class);

        for(int i = 0; i< Arrays.asList(ventaDetalle.getBody()).size(); i++){
            VentaDetalleOut ventaDetalleOut = new VentaDetalleOut();

            ventaDetalleOut.setVentaId(Arrays.asList(ventaDetalle.getBody()).get(i).getVenta().getVentaId());
            ventaDetalleOut.setFecha(Arrays.asList(ventaDetalle.getBody()).get(i).getVenta().getFecha());
            ventaDetalleOut.setMenu(Arrays.asList(ventaDetalle.getBody()).get(i).getMenu().getId());
            ventaDetalleOut.setPrecio(Arrays.asList(ventaDetalle.getBody()).get(i).getPrecio());

            reportes.add(ventaDetalleOut);
        }

        try {
            URI uri = new URI(url+"/api/reporte/datos");
            HistoricalReport report = new HistoricalReport("respuesta_reporte",reportes);
            HttpEntity<HistoricalReport> entity = new HttpEntity<>(report, headers);
            this.restTemplate.postForObject(uri, entity, HistoricalReport.class);
            System.out.println("Reporte enviado");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(ventaDetalle.getBody());
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
