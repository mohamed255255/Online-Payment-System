package Main.controller;
import Main.Service.UserService;
import Main.model.*;
import Main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api")

public class UserController {

    private final UserService userService ;
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    public UserController(UserService userService){
         this.userService = userService ;
    }

    @PostMapping("/signup")
    String signup(@RequestBody SystemUserDB user){
        userService.saveuser( user );
        return "you successfully signed up";
    }

    @PostMapping("/signin")
    ResponseEntity<String> signIn(@RequestBody SystemUserDB user) {
        return userService.login(user);
    }


    @GetMapping("/search")
    List<servicesDB> SearchServiceByName(@RequestParam("type_of_service") String type_of_service){
       return userService.search(type_of_service);
    }

    @GetMapping("/checkDiscount")
    List<DiscountDB> ShowAllDiscounts(){
        return userService.ShowAllDiscounts();
    }

    @GetMapping("/addtowallet")
    public void AddtoWallet(){
        userService.AddtoWallet();
    }
}
