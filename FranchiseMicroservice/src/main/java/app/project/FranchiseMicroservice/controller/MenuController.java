package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.postgres.Menu;
import app.project.FranchiseMicroservice.service.MenuService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/name/{id}")
    public ResponseEntity<Optional<Menu>> get_menu_controller(@PathVariable Long id){
        return new ResponseEntity<Optional<Menu>>(menuService.get_menu_service(id),HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<JSONObject> search_menu_controller(@PathVariable String name){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre",menuService.search_menu_service(name).getNombre());
        jsonObject.put("urlImagen",menuService.search_menu_service(name).getUrlImagen());
        return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<JSONArray> get_all_menu_controller(){
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<menuService.get_all_menu_service().size(); i++){
            JSONObject jsonObject = new JSONObject();
            if (menuService.get_all_menu_service().get(i).getActivo()){
                jsonObject.put("nombre",menuService.get_all_menu_service().get(i).getNombre());
                jsonObject.put("urlImagen",menuService.get_all_menu_service().get(i).getUrlImagen());
                jsonArray.add(jsonObject);
            }
        }

        return new ResponseEntity<JSONArray>(jsonArray,HttpStatus.OK);
    }

    @GetMapping("/all/active")
    public ResponseEntity<JSONArray> get_all_menu_controller_active(){
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<menuService.get_all_menu_service_active().size(); i++){
            JSONObject jsonObject = new JSONObject();
            if (menuService.get_all_menu_service_active().get(i).getActivo()){
                jsonObject.put("nombre",menuService.get_all_menu_service_active().get(i).getNombre());
                jsonObject.put("urlImagen",menuService.get_all_menu_service_active().get(i).getUrlImagen());
                jsonArray.add(jsonObject);
            }
        }

        return new ResponseEntity<JSONArray>(jsonArray,HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<List<Menu>> save_all_menu_controller(List<Menu> menu){
        return new ResponseEntity<List<Menu>>(menuService.save_all_menu_service(menu),HttpStatus.OK);
    }
}
