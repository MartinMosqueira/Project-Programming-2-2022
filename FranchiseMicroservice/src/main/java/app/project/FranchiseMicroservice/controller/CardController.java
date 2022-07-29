package app.project.FranchiseMicroservice.controller;

import app.project.FranchiseMicroservice.model.Card;
import app.project.FranchiseMicroservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    /*FIXME return --number, --company, --expiration*/
    @GetMapping("/all/{id}")
    public ResponseEntity<List<Card>> get_all_card_user_controller(@PathVariable Long id){
        return new ResponseEntity<List<Card>>(cardService.get_all_card_user_service(id), HttpStatus.OK);
    }
}
