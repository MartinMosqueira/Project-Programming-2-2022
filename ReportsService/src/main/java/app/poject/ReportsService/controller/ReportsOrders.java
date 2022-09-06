package app.poject.ReportsService.controller;

import app.poject.ReportsService.client.ConsulClient;
import app.poject.ReportsService.model.OrderDetails;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportsOrders {
    @Autowired
    private ConsulClient consulClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{date1}/{date2}")
    public ResponseEntity<JSONArray> get_order_history(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        ResponseEntity<OrderDetails[]> orderDetails =restTemplate.getForEntity(selectUri.resolve("/details/history/"+date1+"/"+date2), OrderDetails[].class);

        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<Arrays.asList(orderDetails.getBody()).size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("date",Arrays.asList(orderDetails.getBody()).get(i).getOrders().getDate());
            jsonObject.put("time",Arrays.asList(orderDetails.getBody()).get(i).getOrders().getId());
            jsonObject.put("menu",Arrays.asList(orderDetails.getBody()).get(i).getMenu().getName());
            jsonObject.put("quantity",Arrays.asList(orderDetails.getBody()).get(i).getPrice());
            jsonArray.add(jsonObject);
        }
        return new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);

    }
}
