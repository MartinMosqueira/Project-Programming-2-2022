package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.model.Orders;
import app.project.FranchiseMicroservice.service.OrderDetailsService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
            jsonObject.put("idOrder",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getId());
            jsonObject.put("date",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getDate());
            jsonObject.put("total",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getTotal());
            jsonObject.put("menu",orderDetailsService.get_orderDetails_user_service(id).get(i).getMenu().getName());
            jsonObject.put("price",orderDetailsService.get_orderDetails_user_service(id).get(i).getPrice());
            jsonObject.put("user",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getUsers().getName());
            jsonObject.put("idUser",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getUsers().getId());
            jsonObject.put("cardNumber",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getCard().getNumber());
            jsonObject.put("cardCompany",orderDetailsService.get_orderDetails_user_service(id).get(i).getOrders().getCard().getCompany().getName());
            jsonArray.add(jsonObject);
        }
        return new ResponseEntity<JSONArray>(jsonArray,HttpStatus.OK);
    }

    //REPORTS REQUESTS

    @GetMapping("/history/{date1}/{date2}")
    public ResponseEntity<List<OrderDetails>> get_history_reports(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return new ResponseEntity<List<OrderDetails>>(orderDetailsService.get_history_report(date1,date2),HttpStatus.OK);
    }
}
