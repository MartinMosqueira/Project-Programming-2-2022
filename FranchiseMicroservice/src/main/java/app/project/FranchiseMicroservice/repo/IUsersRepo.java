package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepo extends JpaRepository<Users, Integer> {

}
