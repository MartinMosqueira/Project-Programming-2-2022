package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.postgres.VentaDetalle;
import app.project.FranchiseMicroservice.repo.postgres.IVentaDetalleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class VentaDetalleService {
    @Autowired
    private IVentaDetalleRepo orderDetailsRepo;

    public final static Logger LOGGER = LoggerFactory.getLogger(VentaDetalleService.class);

    public VentaDetalle create_ventaDetalle_service(VentaDetalle ventaDetalle){
        try {
            orderDetailsRepo.save(ventaDetalle);
            LOGGER.debug("Product sale: " + ventaDetalle);

        }catch (Exception e){
            LOGGER.error("Product sale error: " + e.getMessage());
            return orderDetailsRepo.save(ventaDetalle);
        }
        return ventaDetalle;
    }

    public List<VentaDetalle> get_all_ventaDetalle_service(){
        return orderDetailsRepo.findAll();
    }

    public List<VentaDetalle> get_date_ventaDetalle_service(Instant date1, Instant date2){
        return orderDetailsRepo.findAllByVentaFechaBetween(date1, date2);
    }
}
