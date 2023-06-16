    package Main.Service;
import Main.model.*;
import Main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    public final ServicesRepository ServicesRepository;
    public final UserRepository userRepository ;
    public final RefundRequestRepository refundRequestRepository ;
    public final transactionRepository transactionRepository ;

    @Autowired
    public AdminService(ServicesRepository ServicesRepository,
                        UserRepository userRepository,
                        RefundRequestRepository refundRequestRepository,
                        transactionRepository transactionRepository) {

        this.ServicesRepository = ServicesRepository;
        this.userRepository = userRepository;
        this.refundRequestRepository = refundRequestRepository;
        this.transactionRepository = transactionRepository;
    }


    public void  AddNewServiceProvider(servicesDB service){
        ServicesRepository.save(service);
    }

    public List<RefundRequestDB> GetAllRefundRequests(){
         return refundRequestRepository.GetAllRefundRequests();
    }

    public List<transactionDB> GetAllTransactions(){
        return transactionRepository.GetAllTransactions();
    }


}
