package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface IVentaRepo extends JpaRepository<Venta, Long> {
}
