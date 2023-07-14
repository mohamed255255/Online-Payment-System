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
    public final WalletRepository  walletRepository ;
    @Autowired
    public UserService(UserRepository UserRepository ,
                       ServicesRepository servicesRepository,
                       DiscountRepository discountRepository,
                       transactionRepository transactionRepository,
                       RefundRequestRepository refundRequestRepository, WalletRepository walletRepository) {

        this.UserRepository = UserRepository;
        this.servicesRepository = servicesRepository;
        this.discountRepository = discountRepository;
        this.transactionRepository = transactionRepository;
        this.refundRequestRepository = refundRequestRepository;
        this.walletRepository = walletRepository;
    }


    public ResponseEntity<String> signup(User user) {
        Optional<User> userOptional = UserRepository.findUserByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("the email is used before");
        }


       /* wallet newWallet = new wallet();
        // set wallet properties

        UserRepository.save(user);

        wallet w = new wallet();
        user.setWallet(w);
        walletRepository.save(newWallet);
        UserRepository.*/



        return ResponseEntity.ok("Sign-up successful");
    }
    public ResponseEntity<String> login(User user ){
        Optional<User> userOptional = UserRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            if (foundUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Sign-in successful");
            }else{
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        }else{
            return ResponseEntity.badRequest().body("User not found");
        }
    }


    public List<services> search(String ServiceName){
        return servicesRepository.findAllMatchingServices(ServiceName);
    }

    public List<Discount> ShowAllDiscounts(){
        return discountRepository.findAllDiscounts();
    }

    /*public void AddtoWallet(int userId, creditcard creditCard , int amount)  {
        User user = UserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        wallet wallet = user.getWallet();
        wallet.addFunds(creditCard , amount );
    }
    public void payforService(services service , User user ){
         Discount discount = discountRepository.findByServiceType(service.getServiceType());
         if(discount != null){
            double PriceAfterDiscount =  discount.getDiscountPercentage() * service.getFees() ;
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

    /*public ResponseEntity<User> welcomeFirstname(){
       User user = UserRepository.findUserByEmail()
    }*/
}
