package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuRepo extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
}
