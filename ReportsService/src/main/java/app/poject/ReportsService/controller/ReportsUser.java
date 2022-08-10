package app.poject.ReportsService.controller;

import app.poject.ReportsService.client.ConsulClient;
import app.poject.ReportsService.config.AppConfiguration;
import app.poject.ReportsService.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportsUser {
    @Autowired
    private ConsulClient consulClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Users get_user(@PathVariable String id){
        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        Users users =restTemplate.getForObject(selectUri.resolve("/user/user/"+id), Users.class);
        return users;
    }
}
