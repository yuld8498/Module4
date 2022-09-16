package com.codegym.mavenbankingajax.controller.res;


import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Deposit;
import com.codegym.mavenbankingajax.model.dto.DepositDTO;
import com.codegym.mavenbankingajax.service.customer.ICustomerService;
import com.codegym.mavenbankingajax.service.deposit.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposits")
public class ResDepositController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IDepositService depositService;

    @PostMapping()
    public ResponseEntity<?> doDepositFromDepositDTO(@RequestBody DepositDTO depositDTO) {
        Customer customer = customerService.findById(depositDTO.getCustomerId()).get();
        Deposit deposit = depositDTO.toDeposit(customer);
        DepositDTO newDepositDTO;
        try{
             newDepositDTO = customerService.doDeposit(depositDTO);
        }catch (Exception e){
            return new ResponseEntity<>("Please contact to administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        depositService.save(deposit);
        return new ResponseEntity<>(newDepositDTO, HttpStatus.OK);
    }
}
