package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.Card;
import app.project.FranchiseMicroservice.service.CardService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/all/{id}")
    public ResponseEntity<JSONArray> get_all_card_user_controller(@PathVariable Long id){
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<cardService.get_all_card_user_service(id).size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("number",cardService.get_all_card_user_service(id).get(i).getNumber());
            jsonObject.put("company",cardService.get_all_card_user_service(id).get(i).getCompany().getName());
            jsonObject.put("expiration",cardService.get_all_card_user_service(id).get(i).getExpiration());
            jsonArray.add(jsonObject);
        }

        return new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Card> create_card_user_controller(@Validated @RequestBody Card card){
        return new ResponseEntity<Card>(cardService.create_card_user_service(card),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Card>> get_card_user_controller(@PathVariable Long id){
        return new ResponseEntity<Optional<Card>>(cardService.get_card_user_service(id),HttpStatus.OK);
    }

    /*NOTE: UPDATE CARD*/
    @PutMapping("update/number/{id}")
    public  ResponseEntity<Void> update_card_number_controller(@PathVariable Long id, @Validated @RequestBody Card card){
        cardService.update_card_number_service(card, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("update/name/{id}")
    public  ResponseEntity<Void> update_card_name_controller(@PathVariable Long id, @Validated @RequestBody Card card){
        cardService.update_card_name_service(card, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("update/expiration/{id}")
    public  ResponseEntity<Void> update_card_expiration_controller(@PathVariable Long id, @Validated @RequestBody Card card){
        cardService.update_card_expiration_service(card, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("update/code/{id}")
    public  ResponseEntity<Void> update_card_code_controller(@PathVariable Long id, @Validated @RequestBody Card card){
        cardService.update_card_code_service(card, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("update/dni/{id}")
    public  ResponseEntity<Void> update_card_dni_controller(@PathVariable Long id, @Validated @RequestBody Card card){
        cardService.update_card_dni_service(card, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
