package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    public OrderDetails create_orderDetails_service(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }

    public List<OrderDetails> get_orderDetails_user_service(Long id){
        return orderDetailsRepo.findAllByOrdenUsuarioId(id);
    }

    public List<OrderDetails> get_history_report(Instant fecha1, Instant fecha2){
        return orderDetailsRepo.findAllByOrdenFechaBetween(fecha1, fecha2);
    }

}
