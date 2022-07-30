package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    public OrderDetails create_orderDetails_service(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }
}
