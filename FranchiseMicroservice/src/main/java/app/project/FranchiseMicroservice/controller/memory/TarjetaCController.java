package app.project.FranchiseMicroservice.controller.memory;

import app.project.FranchiseMicroservice.model.h2.TarjetaC;
import app.project.FranchiseMicroservice.service.memory.TarjetaCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tarjetaC")
public class TarjetaCController {

    @Autowired
    private TarjetaCService tarjetaCService;

    @PostMapping("/add")
    public ResponseEntity<TarjetaC> create_tarjeta_carrito_controller(@Validated @RequestBody TarjetaC tarjetaC){
        return new ResponseEntity<TarjetaC>(tarjetaCService.create_tarjeta_carrito_service(tarjetaC), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TarjetaC>> get_tarjeta_carrito_controller(){
        return new ResponseEntity<List<TarjetaC>>(tarjetaCService.get_tarjeta_carrito_service(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<TarjetaC> delete_tarjeta_carrito_controller(){
        tarjetaCService.delete_tarjeta_carrito_service();
        return new ResponseEntity<TarjetaC>(HttpStatus.OK);
    }
}
