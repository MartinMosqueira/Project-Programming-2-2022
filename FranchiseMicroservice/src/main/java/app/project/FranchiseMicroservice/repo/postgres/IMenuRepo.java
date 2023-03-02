package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepo extends JpaRepository<Menu, Long> {
    Menu findByNombre(String nombre);
    List<Menu> findAllByActivoIsTrue();
}
