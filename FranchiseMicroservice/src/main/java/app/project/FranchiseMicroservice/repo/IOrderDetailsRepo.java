package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

}
