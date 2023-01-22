package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.config.ThreadPoolTaskSchedulerConfig;
import app.project.FranchiseMicroservice.model.OrderDetails;
import app.project.FranchiseMicroservice.repo.IOrderDetailsRepo;
import io.netty.util.concurrent.ScheduledFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderDetailsService {
    @Autowired
    private IOrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig;

    public OrderDetails create_orderDetails_service(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }

    public List<OrderDetails> get_orderDetails_user_service(Long id){
        return orderDetailsRepo.findAllByOrdenUsuarioId(id);
    }

}
