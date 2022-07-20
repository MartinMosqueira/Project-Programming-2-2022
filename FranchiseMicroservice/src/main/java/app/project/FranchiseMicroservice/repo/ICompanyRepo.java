package app.project.FranchiseMicroservice.repo;

import app.project.FranchiseMicroservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepo extends JpaRepository<Company, Long> {

}
