package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepo extends JpaRepository<Cart, Long> {

}
