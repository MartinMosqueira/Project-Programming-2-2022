package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUsersId(Long id);
}
