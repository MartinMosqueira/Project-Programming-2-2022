package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import app.project.FranchiseMicroservice.scheduler.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    @Autowired
    private Reports reports;

    public OrderDetails create_orderDetails_service(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }

    public List<OrderDetails> get_orderDetails_user_service(Long id){
        return orderDetailsRepo.findAllByOrdersUsersId(id);
    }

    public List<OrderDetails> get_history_report(LocalDate date1, LocalDate date2){
        return orderDetailsRepo.findAllByOrdersDateBetween(date1, date2);
    }

    public void get_recurrent_report(){
        reports.get_recurrent_report();
    }
}
