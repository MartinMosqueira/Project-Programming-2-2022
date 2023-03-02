package app.project.FranchiseMicroservice.controller.memory;

import app.project.FranchiseMicroservice.model.h2.Carrito;
import app.project.FranchiseMicroservice.service.memory.CarritoService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @PostMapping("/save")
    public ResponseEntity<Carrito> create_carrito_controller(@Validated @RequestBody Carrito carrito){
        return new ResponseEntity<Carrito>(carritoService.create_carrito_service(carrito), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<JSONArray> get_all_carrito_controller(){
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<carritoService.get_all_carrito_service().size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre",carritoService.get_all_carrito_service().get(i).getMenu().getNombre());
            jsonObject.put("precio",carritoService.get_all_carrito_service().get(i).getMenu().getPrecio());
            jsonObject.put("cantidad",carritoService.get_all_carrito_service().get(i).getCantidad());
            jsonArray.add(jsonObject);
        }
        return new ResponseEntity<JSONArray>(jsonArray,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete_carrito_controller(@PathVariable Long id){
        carritoService.delete_carrito_service(id);
        return new ResponseEntity<String>("Carrito eliminado",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update_carrito_controller(@PathVariable Long id, @Validated @RequestBody Carrito carrito){
        carritoService.update_carrito_service(id,carrito);
        return new ResponseEntity<String>("Carrito actualizado",HttpStatus.OK);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancel_buy_carrito_controller(){
        carritoService.cancel_buy_carrito_service();
        return new ResponseEntity<String>("Compra cancelada",HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buy_carrito_controller(){
        carritoService.buy_carrito_service();
        return new ResponseEntity<String>("Compra realizada",HttpStatus.OK);
    }

}
