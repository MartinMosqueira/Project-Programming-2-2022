package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.service.MainServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/main-server")
public class MainServerController {

    @Autowired
    private MainServerService mainServerService;

    @GetMapping("/action")
    public String action_query_main_server_controller(){
        this.mainServerService.action_query_main_server_service();
        return "action_query_main_server_controller";
    }
}
