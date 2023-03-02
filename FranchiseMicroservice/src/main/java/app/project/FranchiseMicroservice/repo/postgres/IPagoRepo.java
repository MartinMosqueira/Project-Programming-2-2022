package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepo extends JpaRepository<Pago, Long> {
    Pago findByNombre(String nombre);
}
