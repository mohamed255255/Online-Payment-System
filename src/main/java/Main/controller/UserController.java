package Main.controller;
import Main.Service.UserService;
import Main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api")

public class UserController {

    private final UserService userService ;
    @Autowired
    public UserController(UserService userService){
         this.userService = userService ;
    }

    @PostMapping("/signup")
    String signup(@RequestBody SystemUser user){
        userService.saveuser( user );
        return "you successfully signed up";
    }

    @PostMapping("/signin")
    ResponseEntity<String> signIn(@RequestBody SystemUser user) {
        return userService.login(user);
    }


    @GetMapping("/search")
    List<services> SearchServiceByName(@RequestParam("type_of_service") String type_of_service){
       return userService.search(type_of_service);
    }

    @GetMapping("/checkDiscount")
    List<Discount> ShowAllDiscounts(){
        return userService.ShowAllDiscounts();
    }

    @PostMapping("/addtowallet")
    public void AddtoWallet(@RequestParam("userId") int userId,
                            @RequestParam("creditCard") creditcard creditCard,
                            @RequestParam("amount") int amount) {

        userService.AddtoWallet(userId, creditCard, amount);
    }

    @PostMapping("/pay")
    public void payforService(services service , SystemUser user){
        userService.payforService(service , user);
    }

    @PostMapping("/RefundRequest")
    public void AskForRefund(RefundRequest RefundRequest){
        userService.AskForRefund(RefundRequest);
    }

}

