package app.project.FranchiseMicroservice.service.memory;

import app.project.FranchiseMicroservice.model.h2.TarjetaC;
import app.project.FranchiseMicroservice.repo.h2.ITarjetaCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaCService {
    @Autowired
    private ITarjetaCRepo tarjetaCRepo;

    public TarjetaC create_tarjeta_carrito_service(TarjetaC tarjetaC) {
        return tarjetaCRepo.save(tarjetaC);
    }

    public List<TarjetaC> get_tarjeta_carrito_service() {
        return tarjetaCRepo.findAll();
    }

    public void delete_tarjeta_carrito_service() {
        tarjetaCRepo.deleteAll();
        }
}
