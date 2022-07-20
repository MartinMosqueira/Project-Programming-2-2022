package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepo extends JpaRepository<Payment, Long> {

}
