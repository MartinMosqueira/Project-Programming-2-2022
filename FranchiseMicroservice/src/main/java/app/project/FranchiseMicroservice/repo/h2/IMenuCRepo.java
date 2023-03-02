package app.project.FranchiseMicroservice.repo.h2;

import app.project.FranchiseMicroservice.model.h2.MenuC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuCRepo extends JpaRepository<MenuC, Long> {
}
