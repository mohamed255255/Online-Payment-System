package Main.controller;
import Main.Service.AdminService;
import Main.model.Discount;
import Main.model.RefundRequest;
import Main.model.services;
import Main.model.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(path = "/QuickPay")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class AdminController {
    @Autowired
    public final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/addservice")
    public void addNewService(@RequestBody services service){
        adminService.addNewService(service);
    }

    @PostMapping("/addDiscount")
    public void addDiscount(@RequestBody Discount discount){
        adminService.addDiscount(discount);
    }

    @GetMapping("/getAllRefundReq")
    public List<RefundRequest> GetAllRefundRequests(){return adminService.GetAllRefundRequests() ;}


    @GetMapping("/GetTransactions")
    public List<transaction> GetAllTransactions(){ return adminService.GetAllTransactions() ;}

}


