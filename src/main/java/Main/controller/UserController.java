package Main.controller;
import Main.Service.UserService;
import Main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/QuickPay")
    @CrossOrigin(origins = "http://127.0.0.1:5500")

public class UserController {

    private final UserService userService ;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService ;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup (@RequestBody User user){
        return  userService.signup( user );
    }

    @PostMapping("/signin")
    ResponseEntity<String> signIn(@RequestBody User user) {
        return userService.login(user);
    }


    @GetMapping("/search")
    List<services> SearchServiceByName(@RequestParam("servicename") String servicename){
        return userService.search(servicename);
    }

    @GetMapping("/checkDiscount")
    List<Discount> ShowAllDiscounts(){
        return userService.ShowAllDiscounts();
    }

  /*  @PostMapping("/addtowallet")
    public void AddtoWallet(@RequestParam("userId") int userId,
                            @RequestParam("creditCard") creditcard creditCard,
                            @RequestParam("amount") int amount) {

        userService.AddtoWallet(userId, creditCard, amount);
    }

    @PostMapping("/pay")
    public void payforService(services service , User user){
        userService.payforService(service , user);
    }

    @PostMapping("/RefundRequest")
    public void AskForRefund(RefundRequest RefundRequest){
        userService.AskForRefund(RefundRequest);
    }
*/
}