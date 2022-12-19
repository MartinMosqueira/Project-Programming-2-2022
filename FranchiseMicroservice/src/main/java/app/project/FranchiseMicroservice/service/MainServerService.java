package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.MainServerConfiguration;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryIn;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryOut;
import app.project.FranchiseMicroservice.repo.IMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.transaction.Transactional;
import java.time.Duration;

@Service
@Transactional
public class MainServerService {
    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private IMenuRepo menuRepo;

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

        System.out.println(result.toString());
    }

}
