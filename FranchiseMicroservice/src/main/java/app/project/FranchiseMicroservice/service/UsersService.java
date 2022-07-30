package app.project.FranchiseMicroservice.service;

import app.project.FranchiseMicroservice.model.Users;
import app.project.FranchiseMicroservice.repo.IUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private IUsersRepo usersRepo;

    public Users createUserService(Users user){
        return usersRepo.save(user);
    }

    public Optional<Users> get_user_service(Long id){
        return usersRepo.findById(id);
    }
}
