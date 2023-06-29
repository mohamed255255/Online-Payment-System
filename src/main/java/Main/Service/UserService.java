package Main.Service;

import Main.model.*;
import Main.repository.*;
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
    public final transactionRepository transactionRepository;
    public final RefundRequestRepository refundRequestRepository;
    @Autowired
    public UserService(UserRepository UserRepository ,
                       ServicesRepository servicesRepository,
                       DiscountRepository discountRepository,
                       transactionRepository transactionRepository,
                       RefundRequestRepository refundRequestRepository) {

        this.UserRepository = UserRepository;
        this.servicesRepository = servicesRepository;
        this.discountRepository = discountRepository;
        this.transactionRepository = transactionRepository;
        this.refundRequestRepository = refundRequestRepository;
    }

    public ResponseEntity<String> saveuser(SystemUser user){
        Optional<SystemUser> userOptional = UserRepository.findUserByEmail(user.getEmail());
          if(!userOptional.isPresent()){
              UserRepository.save(user);
              return ResponseEntity.ok("Sign-up successful");
          }
        return ResponseEntity.badRequest().body("the email is used before");
    }
    public ResponseEntity<String> login(SystemUser user ){
        Optional<SystemUser> userOptional = UserRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            SystemUser foundUser = userOptional.get();
            if (foundUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Sign-in successful");
            }else{
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        }else{
            return ResponseEntity.badRequest().body("User not found");
        }
    }


    public List<services> search(String type_of_service){
       return servicesRepository.findAllMatchingServices(type_of_service);
    }

    public List<Discount> ShowAllDiscounts(){
        return discountRepository.findAllDiscounts();
    }

    public void AddtoWallet(int userId, creditcard creditCard , int amount)  {
        SystemUser user = UserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        wallet wallet = user.getWallet();
        wallet.addFunds(creditCard , amount );
    }
    public void payforService(services service , SystemUser user ){
         Discount discount = discountRepository.findByServiceType(service.getServiceType());
         if(discount != null){
            double PriceAfterDiscount =  discount.getDiscountPercentage() * service.getSerivcePrice() ;
             wallet wallet = user.getWallet();
             double BalanceAfterPayment = wallet.getBalance() - PriceAfterDiscount ;
             wallet.setBalance(BalanceAfterPayment);
         }else{
             wallet wallet = user.getWallet();
             double BalanceAfterPayment = wallet.getBalance();
             wallet.setBalance(BalanceAfterPayment);
         }
         transaction payment_transaction = new transaction(service.getServiceType() , service.getServiceName() , "payment transaction" );
         transactionRepository.save(payment_transaction);

         /// this method only use the money from the users wallet
         //// keep in mind there might be other ways 1.paypal 2.credit card 3. cash on deleviery or more
         /// so i need to refactor this code and add some design pattern to reduce code redunduncy
         // and to ease readability and maintainability
    }

    public void AskForRefund(RefundRequest RefundRequest){
        refundRequestRepository.save(RefundRequest);
    }
}
