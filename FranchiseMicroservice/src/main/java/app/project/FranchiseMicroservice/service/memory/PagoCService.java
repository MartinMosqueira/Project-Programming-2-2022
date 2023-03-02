package app.project.FranchiseMicroservice.service.memory;

import app.project.FranchiseMicroservice.model.h2.PagoC;
import app.project.FranchiseMicroservice.repo.h2.IPagoCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoCService {

    @Autowired
    private IPagoCRepo pagoCRepo;

    public PagoC create_pago_carrito_service(PagoC pagoC){
        return this.pagoCRepo.save(pagoC);
    }

    public List<PagoC> get_pago_carrito_service(){
        return this.pagoCRepo.findAll();
    }

    public void delete_pago_carrito_service(){
        this.pagoCRepo.deleteAll();
    }
}
