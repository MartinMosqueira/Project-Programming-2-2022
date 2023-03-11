package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.postgres.VentaDetalle;
import app.project.FranchiseMicroservice.service.VentaDetalleService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/detalle")
public class VentaDetalleController {
    @Autowired
    private VentaDetalleService ventaDetalleService;

    @PostMapping("/create")
    public ResponseEntity<VentaDetalle> create_orderDetails_controller(@Validated @RequestBody VentaDetalle ventaDetalle){
        return new ResponseEntity<VentaDetalle>(ventaDetalleService.create_ventaDetalle_service(ventaDetalle), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VentaDetalle>> get_all_orderDetails_controller(){
        return new ResponseEntity<List<VentaDetalle>>(ventaDetalleService.get_all_ventaDetalle_service(), HttpStatus.OK);
    }

    @GetMapping("/date/{date1}/{date2}")
    public ResponseEntity<List<VentaDetalle>> get_date_ventaDetalle_controller(@PathVariable Instant date1, @PathVariable Instant date2){
        return new ResponseEntity<List<VentaDetalle>>(ventaDetalleService.get_date_ventaDetalle_service(date1, date2), HttpStatus.OK);
    }

}
