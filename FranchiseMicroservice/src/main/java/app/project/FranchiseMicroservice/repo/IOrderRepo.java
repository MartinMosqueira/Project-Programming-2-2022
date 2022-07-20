package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Long> {

}
