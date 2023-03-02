package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.postgres.Menu;
import app.project.FranchiseMicroservice.repo.postgres.IMenuRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private IMenuRepo menuRepo;

    public final static Logger LOGGER = LoggerFactory.getLogger(MenuService.class);

    public Optional<Menu> get_menu_service(Long id){
        return menuRepo.findById(id);
    }

    public Menu search_menu_service(String nombre){
        return menuRepo.findByNombre(nombre);
    }

    public List<Menu> get_all_menu_service(){
        return menuRepo.findAll();
    }

    public List<Menu> get_all_menu_service_active(){
        return menuRepo.findAllByActivoIsTrue();
    }

    public List<Menu> save_all_menu_service(List<Menu> menu){
        try {
            menuRepo.saveAll(menu);
            LOGGER.debug("Update menu: " + menu);
        }catch (Exception e){
            LOGGER.error("Update menu error: " + e.getMessage());
            return menuRepo.saveAll(menu);
        }
        return menu;
    }
}
