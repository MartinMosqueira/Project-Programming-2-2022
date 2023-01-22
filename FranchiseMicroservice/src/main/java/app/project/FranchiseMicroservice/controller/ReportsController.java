package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@CrossOrigin
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    private ReportsService reportsService;

    @GetMapping("/history/{date1}/{date2}")
    public ResponseEntity<Void> get_history_reports(@PathVariable Instant date1, @PathVariable  Instant date2){
        return new ResponseEntity<Void>(HttpStatus.OK);
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
