package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Cart;
import app.project.FranchiseMicroservice.repo.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private ICartRepo cartRepo;

    public Cart save_cart_service(Cart cart){
        return cartRepo.save(cart);
    }

    public void delete_menu_cart_service(Long id){
        cartRepo.deleteById(id);
    }

    public List<Cart> get_all_menu_user_service(Long id){
        return cartRepo.findAllByUsersId(id);
    }
}
