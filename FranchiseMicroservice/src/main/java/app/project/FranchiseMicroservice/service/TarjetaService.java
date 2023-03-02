package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.postgres.Tarjeta;
import app.project.FranchiseMicroservice.repo.postgres.ITarjetaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaService {
    @Autowired
    private ITarjetaRepo cardRepo;

    public Tarjeta create_card_service(Tarjeta tarjeta){
        return cardRepo.save(tarjeta);
    }

    public Optional<Tarjeta> get_card_service(Long id){
        return cardRepo.findById(id);
    }

    public List<Tarjeta> get_all_card_service(){
        return cardRepo.findAll();
    }

}
