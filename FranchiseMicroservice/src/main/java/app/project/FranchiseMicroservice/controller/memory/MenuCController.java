package app.project.FranchiseMicroservice.controller.memory;

import app.project.FranchiseMicroservice.model.h2.MenuC;
import app.project.FranchiseMicroservice.service.memory.MenuCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menuC")
public class MenuCController {
    @Autowired
    private MenuCService menuCService;

    @GetMapping("/save")
    public ResponseEntity<List<MenuC>> save_all_menu_carrito_controller(){
        return new ResponseEntity<List<MenuC>>(menuCService.save_all_menu_carrito_service(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuC>> get_all_menu_carrito_controller(){
        return new ResponseEntity<List<MenuC>>(menuCService.get_all_menu_carrito_service(), HttpStatus.OK);
    }
}
