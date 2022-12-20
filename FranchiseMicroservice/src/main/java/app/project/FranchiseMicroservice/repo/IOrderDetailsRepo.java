package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface IOrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findAllByOrdersUsersId(Long id);
    List<OrderDetails> findAllByOrdersDateBetween(Instant date1, Instant date2);
}
