package app.project.FranchiseMicroservice.controller.memory;

import app.project.FranchiseMicroservice.model.h2.PagoC;
import app.project.FranchiseMicroservice.service.memory.PagoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pagoC")
public class PagoCController {
    @Autowired
    private PagoCService pagoCService;

    @PostMapping("/save")
    public ResponseEntity<PagoC> create_pago_carrito_controller(@Validated @RequestBody PagoC pagoC){
        return new ResponseEntity<PagoC>(pagoCService.create_pago_carrito_service(pagoC), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PagoC>> get_pago_carrito_controller(){
        return new ResponseEntity<List<PagoC>>(pagoCService.get_pago_carrito_service(), HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<PagoC> delete_pago_carrito_controller(){
        pagoCService.delete_pago_carrito_service();
        return new ResponseEntity<PagoC>(HttpStatus.OK);
    }
}
