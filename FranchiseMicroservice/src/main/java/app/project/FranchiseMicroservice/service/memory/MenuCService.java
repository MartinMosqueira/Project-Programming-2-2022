package app.project.FranchiseMicroservice.service.memory;

import app.project.FranchiseMicroservice.model.h2.MenuC;
import app.project.FranchiseMicroservice.model.postgres.Menu;
import app.project.FranchiseMicroservice.repo.h2.IMenuCRepo;
import app.project.FranchiseMicroservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCService {
    @Autowired
    private IMenuCRepo menuCRepo;

    @Autowired
    private MenuService menuService;


    public List<MenuC> save_all_menu_carrito_service(){
        List<Menu> menu = menuService.get_all_menu_service_active();

        for (Menu m: menu) {
            MenuC menuC = new MenuC();
            menuC.setId(m.getId());
            menuC.setNombre(m.getNombre());
            menuC.setPrecio(m.getPrecio());
            menuC.setDescripcion(m.getDescripcion());
            menuCRepo.save(menuC);
        }
        return menuCRepo.findAll();
    }

}
