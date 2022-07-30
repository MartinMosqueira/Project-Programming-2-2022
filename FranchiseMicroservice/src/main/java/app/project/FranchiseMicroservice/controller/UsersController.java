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
        jsonObject.put("name", usersService.get_user_service(id).get().getName());
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
        jsonObject.put("name", usersService.get_user_service(id).get().getName());
        jsonObject.put("birth", usersService.get_user_service(id).get().getBirth());
        return new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
    }
}
