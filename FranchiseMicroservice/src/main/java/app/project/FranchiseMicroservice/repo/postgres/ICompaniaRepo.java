package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompaniaRepo extends JpaRepository<Compania, Long> {
    Compania findByNombre(String nombre);
}
