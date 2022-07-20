package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRepo extends JpaRepository<Menu, Long> {

}
