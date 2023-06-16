package Main.controller;
import Main.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Main.model.*;

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
    public void AddService(@RequestBody servicesDB service){
        adminService.AddNewServiceProvider(service);
    }


    @GetMapping("/getAllRefundReq")
    public List<RefundRequestDB> GetAllRefundRequests(){return adminService.GetAllRefundRequests() ;}


    @GetMapping("/GetTransactions")
    public List<transactionDB> GetAllTransactions(){ return adminService.GetAllTransactions() ;}

}


