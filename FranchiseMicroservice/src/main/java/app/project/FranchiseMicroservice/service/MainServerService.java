package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.MainServerConfiguration;
import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryIn;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryOut;
import app.project.FranchiseMicroservice.modelMainServer.HistoricalReport;
import app.project.FranchiseMicroservice.modelMainServer.Reporte;
import app.project.FranchiseMicroservice.repo.IMenuRepo;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

@Service
@Transactional
public class MainServerService {
    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private IMenuRepo menuRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    public void action_query_main_server_service(){
        String url = this.mainServerConfiguration.getUrl();
        String uuid = this.mainServerConfiguration.getUuid();
        String token = this.mainServerConfiguration.getToken();
        String path = this.mainServerConfiguration.getPath();
        HttpClient httpClient=HttpClient.create().responseTimeout(Duration.ofMillis(1000));

        WebClient webClient=WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(url+path)
                .defaultHeaders(httpHeaders ->  {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer "+token);
                    httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                })
                .build();

        ActionQueryOut data=new ActionQueryOut();
        data.setAccion("consulta");
        data.setFranquiciaID(uuid);

        Mono<ActionQueryIn> response=webClient.post()
            .body(Mono.just(data), ActionQueryOut.class)
                .retrieve()
                .bodyToMono(ActionQueryIn.class);
        ActionQueryIn result = null;
        try {
            result = response.block();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(result.getMenus() != null){
            this.menuRepo.saveAll(result.getMenus());
        }
        else if (result.getReporte() != null){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer "+token);

            try {
                URI uri = new URI(url+"/api/reporte/datos");
                List<OrderDetails> reportes= this.orderDetailsRepo.findAllByOrdenFechaBetween(result.getReporte().getFechaInicio(), result.getReporte().getFechaFin());
                HistoricalReport report = new HistoricalReport("respuesta_reporte",reportes);
                HttpEntity<HistoricalReport> entity = new HttpEntity<>(report, headers);
                this.restTemplate.postForObject(uri, entity, HistoricalReport.class);

            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        System.out.println(result.toString());
    }

}
