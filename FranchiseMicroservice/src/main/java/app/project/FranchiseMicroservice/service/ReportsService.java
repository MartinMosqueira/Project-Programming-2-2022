package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.MainServerConfiguration;
import app.project.FranchiseMicroservice.config.ThreadPoolTaskSchedulerConfig;
import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.modelMainServer.HistoricalReport;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
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
import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig;

    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    public List<OrderDetails> get_history_report(Instant fecha1, Instant fecha2){
        String url = this.mainServerConfiguration.getUrl();
        String token = this.mainServerConfiguration.getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        try {
            URI uri = new URI(url+"/api/reporte/datos");
            List<OrderDetails> reportes = this.orderDetailsRepo.findAllByOrdenFechaBetween(fecha1, fecha2);
            HistoricalReport report = new HistoricalReport("respuesta_reporte",reportes);
            HttpEntity<HistoricalReport> entity = new HttpEntity<>(report, headers);
            this.restTemplate.postForObject(uri, entity, HistoricalReport.class);
            System.out.println("Reporte enviado");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return this.orderDetailsRepo.findAllByOrdenFechaBetween(fecha1, fecha2);
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
