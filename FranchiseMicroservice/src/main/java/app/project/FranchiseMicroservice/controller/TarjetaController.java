package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.postgres.Tarjeta;
import app.project.FranchiseMicroservice.service.TarjetaService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;

    @PostMapping("/create")
    public ResponseEntity<Tarjeta> create_card_controller(@Validated @RequestBody Tarjeta tarjeta){
        return new ResponseEntity<Tarjeta>(tarjetaService.create_card_service(tarjeta),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Tarjeta>> get_card_controller(@PathVariable Long id){
        return new ResponseEntity<Optional<Tarjeta>>(tarjetaService.get_card_service(id),HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Tarjeta>> get_all_card_controller(){
        return new ResponseEntity<List<Tarjeta>>(tarjetaService.get_all_card_service(),HttpStatus.OK);
    }

}
