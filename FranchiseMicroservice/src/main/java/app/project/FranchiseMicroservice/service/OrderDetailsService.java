package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    public final static Logger LOGGER = LoggerFactory.getLogger(OrderDetailsService.class);

    public OrderDetails create_orderDetails_service(OrderDetails orderDetails){
        try {
            orderDetailsRepo.save(orderDetails);
            LOGGER.debug("Product sale: " + orderDetails);

        }catch (Exception e){
            LOGGER.error("Product sale error: " + e.getMessage());
            return orderDetailsRepo.save(orderDetails);
        }
        return orderDetails;
    }

    public List<OrderDetails> get_orderDetails_user_service(Long id){
        return orderDetailsRepo.findAllByOrdenUsuarioId(id);
    }

}
