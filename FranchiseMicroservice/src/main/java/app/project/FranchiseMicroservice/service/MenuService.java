package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Menu;
import app.project.FranchiseMicroservice.repo.IMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private IMenuRepo menuRepo;

    public Optional<Menu> get_menu_service(Long id){
        return menuRepo.findById(id);
    }

    public Menu search_menu_service(String nombre){
        return menuRepo.findByNombre(nombre);
    }

    public List<Menu> get_all_menu_service(){
        return menuRepo.findAll();
    }
}
