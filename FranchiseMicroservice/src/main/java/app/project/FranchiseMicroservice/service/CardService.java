package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Card;
import app.project.FranchiseMicroservice.repo.ICardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private ICardRepo cardRepo;

    public List<Card> get_all_card_user_service(Long id){
        return cardRepo.findAllByUsuarioId(id);
    }

    public Card create_card_user_service(Card card){
        return cardRepo.save(card);
    }

    public Optional<Card> get_card_user_service(Long id){
        return cardRepo.findById(id);
    }

    /*NOTE: UPDATE CARD*/
    public void update_card_number_service(Card card, Long id){
        Optional<Card> getCard=this.cardRepo.findById(id);
        Card cardSelect=getCard.get();
        cardSelect.setNumero(card.getNumero());

        this.cardRepo.save(cardSelect);
    }

    public void update_card_name_service(Card card, Long id){
        Optional<Card> getCard=this.cardRepo.findById(id);
        Card cardSelect=getCard.get();
        cardSelect.setNombre(card.getNombre());

        this.cardRepo.save(cardSelect);
    }

    public void update_card_expiration_service(Card card, Long id){
        Optional<Card> getCard=this.cardRepo.findById(id);
        Card cardSelect=getCard.get();
        cardSelect.setVencimiento(card.getVencimiento());

        this.cardRepo.save(cardSelect);
    }

    public void update_card_code_service(Card card, Long id){
        Optional<Card> getCard=this.cardRepo.findById(id);
        Card cardSelect=getCard.get();
        cardSelect.setCodigo(card.getCodigo());

        this.cardRepo.save(cardSelect);
    }

    public void update_card_dni_service(Card card, Long id){
        Optional<Card> getCard=this.cardRepo.findById(id);
        Card cardSelect=getCard.get();
        cardSelect.setDni(card.getDni());

        this.cardRepo.save(cardSelect);
    }
}
