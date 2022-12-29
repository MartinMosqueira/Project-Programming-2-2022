package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.Users;
import app.project.FranchiseMicroservice.service.UsersService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUserController(@Validated @RequestBody Users user){
        return new ResponseEntity<Users>(usersService.createUserService(user), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<JSONObject> get_user_controller(@PathVariable Long id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", usersService.get_user_service(id).get().getId());
        jsonObject.put("nombre", usersService.get_user_service(id).get().getNombre());
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<JSONObject> get_user_email_controller(@PathVariable Long id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", usersService.get_user_service(id).get().getEmail());
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }

    @GetMapping("/ident/{id}")
    public ResponseEntity<JSONObject> get_user_identification_controller(@PathVariable Long id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre", usersService.get_user_service(id).get().getNombre());
        jsonObject.put("nacimiento", usersService.get_user_service(id).get().getNacimiento());
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }

    @PutMapping("update/email/{id}")
    public ResponseEntity<Void> update_user_email_controller(@PathVariable Long id, @Validated @RequestBody Users users ){
        usersService.update_user_email_service(users,id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("update/ident/{id}")
    public ResponseEntity<Void> update_user_identity_controller(@PathVariable Long id, @Validated @RequestBody Users users){
        usersService.update_user_identity_service(users,id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
