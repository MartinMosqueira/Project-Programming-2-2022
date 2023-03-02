package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.postgres.Venta;
import app.project.FranchiseMicroservice.repo.postgres.IVentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private IVentaRepo ordersRepo;

    public Venta create_venta_service(Venta venta){
        return ordersRepo.save(venta);
    }

    public List<Venta> get_all_venta_service(){
        return ordersRepo.findAll();
    }
}
