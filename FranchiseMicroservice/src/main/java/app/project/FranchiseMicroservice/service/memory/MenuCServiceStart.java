package app.project.FranchiseMicroservice.service.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuCServiceStart implements CommandLineRunner {

    @Autowired
    private MenuCService menuCService;

    @Override
    public void run(String... args) throws Exception {
        menuCService.save_all_menu_carrito_service();
        System.out.println("update menu carrito");
    }
}
