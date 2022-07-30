package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Card;
import app.project.FranchiseMicroservice.repo.ICardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private ICardRepo cardRepo;

    public List<Card> get_all_card_user_service(Long id){
        return cardRepo.findAllByUsersId(id);
    }

    public Card create_card_user_service(Card card){
        return cardRepo.save(card);
    }
}
