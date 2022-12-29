package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.service.OrderDetailsService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/details")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/create")
    public ResponseEntity<OrderDetails> create_orderDetails_controller(@Validated @RequestBody OrderDetails orderDetails){
        return new ResponseEntity<OrderDetails>(orderDetailsService.create_orderDetails_service(orderDetails), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<JSONArray> get_orderDetails_user_controller(@PathVariable Long id){
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<orderDetailsService.get_orderDetails_user_service(id).size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idOrden",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getId());
            jsonObject.put("fecha",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getFecha());
            jsonObject.put("total",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getTotal());
            jsonObject.put("menu",orderDetailsService.get_orderDetails_user_service(id).get(i).getMenu().getNombre());
            jsonObject.put("precio",orderDetailsService.get_orderDetails_user_service(id).get(i).getPrecio());
            jsonObject.put("usuario",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getUsuario().getNombre());
            jsonObject.put("idUsuario",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getUsuario().getId());
            try{
                jsonObject.put("tarjeta numero",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getTarjeta().getNumero());
                jsonObject.put("compañia",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrden().getTarjeta().getCompania().getNombre());
            }catch (java.lang.NullPointerException ex){
                jsonObject.put("tarjeta numero","Sin tarjeta");
                jsonObject.put("compañia","Sin tarjeta");
            }
            jsonArray.add(jsonObject);
        }
        return new ResponseEntity<JSONArray>(jsonArray,HttpStatus.OK);
    }

    //REPORTS REQUESTS

    @GetMapping("/history/{date1}/{date2}")
    public ResponseEntity<List<OrderDetails>> get_history_reports(@PathVariable Instant date1, @PathVariable  Instant date2){
        return new ResponseEntity<List<OrderDetails>>(orderDetailsService.get_history_report(date1,date2),HttpStatus.OK);
    }

}
