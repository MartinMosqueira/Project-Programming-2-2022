package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICardRepo extends JpaRepository<Card, Long> {
    List<Card> findAllByUsersId(Long id);
}
