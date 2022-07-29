package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepo extends JpaRepository<Orders, Long> {

}
