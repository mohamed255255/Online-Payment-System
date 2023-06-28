package Main.controller;
import Main.Service.AdminService;
import Main.model.DiscountDB;
import Main.model.RefundRequestDB;
import Main.model.servicesDB;
import Main.model.transactionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(path = "/api")
public class AdminController {
    @Autowired
    public final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/addservice")
    public void addNewService(@RequestBody servicesDB service){
        adminService.addNewService(service);
    }

    @PostMapping("/addDiscount")
    public void addDiscount(@RequestBody DiscountDB discount){
        adminService.addDiscount(discount);
    }

    @GetMapping("/getAllRefundReq")
    public List<RefundRequestDB> GetAllRefundRequests(){return adminService.GetAllRefundRequests() ;}


    @GetMapping("/GetTransactions")
    public List<transactionDB> GetAllTransactions(){ return adminService.GetAllTransactions() ;}

}


