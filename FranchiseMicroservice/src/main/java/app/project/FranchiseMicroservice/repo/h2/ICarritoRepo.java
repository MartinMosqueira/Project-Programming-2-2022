package app.project.FranchiseMicroservice.repo.h2;

import app.project.FranchiseMicroservice.model.h2.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepo extends JpaRepository<Carrito, Long> {
}
