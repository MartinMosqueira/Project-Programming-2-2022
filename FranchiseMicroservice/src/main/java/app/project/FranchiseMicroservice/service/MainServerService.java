package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.MainServerConfiguration;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryIn;
import app.project.FranchiseMicroservice.modelMainServer.ActionQueryOut;
import app.project.FranchiseMicroservice.service.memory.MenuCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Objects;

@Service
public class MainServerService {
    @Autowired
    private MainServerConfiguration mainServerConfiguration;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuCService menuCService;

    @Autowired
    private ReportsService reportsService;

    public final static Logger LOGGER = LoggerFactory.getLogger(MainServerService.class);

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
            //update menus database
            menuService.save_all_menu_service(result.getMenus());

            //update menus database carrito
            menuCService.save_all_menu_carrito_service();

        }

        else if (result.getReporte() != null) {

            if (Objects.equals(result.getReporte().getTipo(), "historico")){
                LOGGER.info("historical report request");
                reportsService.get_history_report(result.getReporte().getFechaInicio(), result.getReporte().getFechaFin());
            }
            else if (Objects.equals(result.getReporte().getTipo(), "recurrente")){
                LOGGER.info("recurrent report request");
                reportsService.get_recurrent_report(result.getReporte().getFechaInicio(), result.getReporte().getFechaFin(),result.getReporte().getIntervalo());
            }
            else if (Objects.equals(result.getReporte().getTipo(), "cancelar")) {
                LOGGER.info("cancel recurrent report request");
                reportsService.get_recurrent_report_cancel();
            }
        }
        System.out.println(result.toString());

        }
}
