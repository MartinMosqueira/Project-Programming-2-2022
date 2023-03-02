package app.project.FranchiseMicroservice.repo.h2;

import app.project.FranchiseMicroservice.model.h2.PagoC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoCRepo extends JpaRepository<PagoC, Long> {

}
