package app.poject.ReportsService.controller;

import app.poject.ReportsService.client.ConsulClient;
import app.poject.ReportsService.model.VentaDetalle;
import app.poject.ReportsService.service.ReportsService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportsController {
    @Autowired
    private ConsulClient consulClient;
    @Autowired
    private RestTemplate restTemplate;

    public final static Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);

    @Autowired
    private ReportsService reportsService;

    @GetMapping("/history/{date1}/{date2}")
    public ResponseEntity<List<VentaDetalle>> get_history_reports(@PathVariable Instant date1, @PathVariable  Instant date2){
        LOGGER.debug("history report: " + reportsService.get_history_report(date1,date2));
        return new ResponseEntity<List<VentaDetalle>>(reportsService.get_history_report(date1,date2),HttpStatus.OK);
    }

    @GetMapping("/recurrent/{date1}/{date2}/{duration}")
    public ResponseEntity<Void> get_recurrent_reports(@PathVariable Instant date1, @PathVariable  Instant date2, @PathVariable String duration){
        reportsService.get_recurrent_report(date1,date2,duration);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/recurrent/cancel")
    public ResponseEntity<Void> get_recurrent_report_cancel(){
        reportsService.get_recurrent_report_cancel();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
