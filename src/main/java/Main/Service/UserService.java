package Main.Service;

import Main.model.DiscountDB;
import Main.model.SystemUserDB;
import Main.model.servicesDB;
import Main.repository.DiscountRepository;
import Main.repository.ServicesRepository;
import Main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    public final UserRepository UserRepository;
    public final ServicesRepository servicesRepository;
    public final DiscountRepository discountRepository ;
    @Autowired
    public UserService(UserRepository UserRepository , ServicesRepository servicesRepository, DiscountRepository discountRepository) {
        this.UserRepository = UserRepository;
        this.servicesRepository = servicesRepository;
        this.discountRepository = discountRepository;
    }

    public ResponseEntity<String> saveuser(SystemUserDB user){
          Optional<SystemUserDB> userOptional = UserRepository.findUserByEmail(user.getEmail());
          if(!userOptional.isPresent()){
              UserRepository.save(user);
              return ResponseEntity.ok("Sign-up successful");
          }
        return ResponseEntity.badRequest().body("the email is used before");
    }
    public ResponseEntity<String> login(SystemUserDB user ){
        Optional<SystemUserDB> userOptional = UserRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            SystemUserDB foundUser = userOptional.get();
            if (foundUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Sign-in successful");
            }else{
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        }else{
            return ResponseEntity.badRequest().body("User not found");
        }
    }


    public List<servicesDB> search(String type_of_service){
       return servicesRepository.findAllMatchingServices(type_of_service);
    }

    public List<DiscountDB> ShowAllDiscounts(){
        return discountRepository.findAllDiscounts();
    }

    public void AddtoWallet(SystemUserDB User){
        /// get the user wallet obj
        /// use add funds function inside it to apply the add to wallet mechansim
    }

}
