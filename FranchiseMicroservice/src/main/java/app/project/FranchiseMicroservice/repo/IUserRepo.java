package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {

}
