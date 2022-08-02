package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /*FIXME return --orders.date, --menu.name*/
    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDetails>> get_orderDetails_user_controller(@PathVariable Long id){
        return new ResponseEntity<List<OrderDetails>>(orderDetailsService.get_orderDetails_user_service(id),HttpStatus.OK);
    }

}
