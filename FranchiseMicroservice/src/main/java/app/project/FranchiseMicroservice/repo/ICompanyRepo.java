package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepo extends JpaRepository<Company, Long> {

}
