package Main.Service;

import Main.model.DiscountDB;
import Main.model.RefundRequestDB;
import Main.model.servicesDB;
import Main.model.transactionDB;
import Main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class  AdminService {
    @Autowired
    private DataSource dataSource;

    public final ServicesRepository ServicesRepository;
    public final UserRepository userRepository ;
    public final RefundRequestRepository refundRequestRepository ;
    public final transactionRepository transactionRepository ;
    public final DiscountRepository discountRepository ;

    @Autowired
    public AdminService(ServicesRepository ServicesRepository,
                        UserRepository userRepository,
                        RefundRequestRepository refundRequestRepository,
                        transactionRepository transactionRepository,
                        DiscountRepository discountRepository) {

        this.ServicesRepository = ServicesRepository;
        this.userRepository = userRepository;
        this.refundRequestRepository = refundRequestRepository;
        this.transactionRepository = transactionRepository;
        this.discountRepository = discountRepository;
    }


    public void addNewService(servicesDB newService) {
        ServicesRepository.save(newService);
    }


    public void addDiscount(DiscountDB discount) {
        discountRepository.save(discount);
    }


    public List<RefundRequestDB> GetAllRefundRequests(){
         return refundRequestRepository.GetAllRefundRequests();
    }

    public List<transactionDB> GetAllTransactions(){
        return transactionRepository.GetAllTransactions();
    }


}
