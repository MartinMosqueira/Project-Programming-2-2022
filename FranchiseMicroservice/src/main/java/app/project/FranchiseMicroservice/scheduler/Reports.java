package app.project.FranchiseMicroservice.scheduler;

import app.project.FranchiseMicroservice.repo.IMenuRepo;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Reports {

    @Autowired
    IMenuRepo menuRepo;

    //@Scheduled(fixedDelay = 5000, initialDelay = 3000)
    public void get_recurrent_report(){
        System.out.println(menuRepo.findAll());
    }
}
