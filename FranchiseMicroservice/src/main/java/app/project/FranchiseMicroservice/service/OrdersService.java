package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Orders;
import app.project.FranchiseMicroservice.repo.IOrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private IOrdersRepo ordersRepo;

    public Orders create_order_service(Orders orders){
        return ordersRepo.save(orders);
    }
}
