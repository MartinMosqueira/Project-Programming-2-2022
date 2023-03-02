package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.postgres.Pago;
import app.project.FranchiseMicroservice.repo.postgres.IPagoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
    @Autowired
    private IPagoRepo pagoRepo;

    public Pago create_pago_service(Pago pago){
        return pagoRepo.save(pago);
    }
}
