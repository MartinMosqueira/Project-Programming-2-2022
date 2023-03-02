package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITarjetaRepo extends JpaRepository<Tarjeta, Long> {
}
