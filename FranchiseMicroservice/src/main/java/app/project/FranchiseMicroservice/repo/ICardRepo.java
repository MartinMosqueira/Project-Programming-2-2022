package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepo extends JpaRepository<Card, Long> {

}
