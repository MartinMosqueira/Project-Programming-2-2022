package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.postgres.Venta;
import app.project.FranchiseMicroservice.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/create")
    public ResponseEntity<Venta> create_venta_controller(@Validated @RequestBody Venta venta){
        return new ResponseEntity<Venta>(ventaService.create_venta_service(venta), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Venta>> get_all_venta_controller(){
        return new ResponseEntity<List<Venta>>(ventaService.get_all_venta_service(), HttpStatus.OK);
    }
}
