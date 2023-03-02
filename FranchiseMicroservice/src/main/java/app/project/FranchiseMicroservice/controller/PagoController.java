package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.postgres.Pago;
import app.project.FranchiseMicroservice.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @PostMapping("/create")
    public ResponseEntity<Pago> add_pago_controller(@Validated @RequestBody Pago pago){
        return new ResponseEntity<Pago>(pagoService.create_pago_service(pago), HttpStatus.OK);
    }
}
