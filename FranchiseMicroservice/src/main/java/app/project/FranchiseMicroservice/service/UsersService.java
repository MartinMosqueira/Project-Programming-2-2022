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

    public void update_user_email_service(Users users, Long id){
        Optional<Users> getUser=this.usersRepo.findById(id);
        Users userSelect=getUser.get();
        userSelect.setEmail(users.getEmail());

        this.usersRepo.save(userSelect);
    }

    public void update_user_identity_service(Users users,Long id){
        Optional<Users> getUser=this.usersRepo.findById(id);
        Users userSelect=getUser.get();
        userSelect.setName(users.getName());
        userSelect.setBirth(users.getBirth());

        this.usersRepo.save(userSelect);
    }
}
