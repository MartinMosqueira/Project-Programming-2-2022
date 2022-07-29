package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.Cart;
import app.project.FranchiseMicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public ResponseEntity<Cart> save_cart_controller(@Validated @RequestBody Cart cart){
        return new ResponseEntity<Cart>(cartService.save_cart_service(cart), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete_menu_cart_controller(@PathVariable Long id){
        cartService.delete_menu_cart_service(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /*FIXME return --name*/
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Cart>> get_all_menu_user_controller(@PathVariable Long id){
        return new ResponseEntity<List<Cart>>(cartService.get_all_menu_user_service(id),HttpStatus.OK);
    }
}
