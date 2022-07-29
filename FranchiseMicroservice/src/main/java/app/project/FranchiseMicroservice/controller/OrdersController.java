package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.Orders;
import app.project.FranchiseMicroservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<Orders> create_order_controller(@Validated @RequestBody Orders orders){
        return new ResponseEntity<Orders>(ordersService.create_order_service(orders), HttpStatus.OK);
    }
}
