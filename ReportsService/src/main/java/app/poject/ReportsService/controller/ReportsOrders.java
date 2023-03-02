package app.poject.ReportsService.controller;

import app.poject.ReportsService.client.ConsulClient;
import app.poject.ReportsService.model.VentaDetalle;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportsOrders {
    @Autowired
    private ConsulClient consulClient;
    @Autowired
    private RestTemplate restTemplate;

    public final static Logger LOGGER = LoggerFactory.getLogger(ReportsOrders.class);

    @GetMapping("/history/{date1}/{date2}")
    public ResponseEntity<JSONArray> get_order_history(@PathVariable Instant date1, @PathVariable Instant date2){
        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        ResponseEntity<VentaDetalle[]> ventaDetalle =restTemplate.getForEntity(selectUri.resolve("/reports/history/"+date1+"/"+date2), VentaDetalle[].class);

        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<Arrays.asList(ventaDetalle.getBody()).size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fecha",Arrays.asList(ventaDetalle.getBody()).get(i).getVenta().getFecha());
            jsonObject.put("ventaId",Arrays.asList(ventaDetalle.getBody()).get(i).getVenta().getVentaId());
            jsonObject.put("menu",Arrays.asList(ventaDetalle.getBody()).get(i).getMenu().getId());
            jsonObject.put("precio",Arrays.asList(ventaDetalle.getBody()).get(i).getPrecio());
            jsonArray.add(jsonObject);
        }
        LOGGER.debug("history report: " + jsonArray);
        return new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);

    }

    @GetMapping("/recurrent/{date1}/{date2}/{duration}")
    public ResponseEntity<Void> get_order_recurrent(@PathVariable Instant date1, @PathVariable Instant date2, @PathVariable String duration){
        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        ResponseEntity<Void> ventaDetalle =restTemplate.getForEntity(selectUri.resolve("/reports/recurrent/"+date1+"/"+date2+"/"+duration), Void.class);
        LOGGER.debug("recurrent report: " + ventaDetalle.getBody());
        return new ResponseEntity<Void>(ventaDetalle.getBody(), HttpStatus.OK);
    }

    @GetMapping("/recurrent/cancel")
    public ResponseEntity<Void> get_order_recurrent_cancel(){
        URI selectUri = consulClient.getUri("FRANCHISESERVICE");
        ResponseEntity<Void> ventaDetalle =restTemplate.getForEntity(selectUri.resolve("/reports/recurrent/cancel"), Void.class);
        LOGGER.debug("cancel recurrent report");
        return new ResponseEntity<Void>(ventaDetalle.getBody(), HttpStatus.OK);
    }
}
