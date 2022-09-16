package com.codegym.mavenbankingajax.controller.res;

import com.codegym.mavenbankingajax.model.Customer;
import com.codegym.mavenbankingajax.model.Transfer;
import com.codegym.mavenbankingajax.model.dto.CustomerDTO;
import com.codegym.mavenbankingajax.model.dto.TransferDTO;
import com.codegym.mavenbankingajax.service.customer.ICustomerService;
import com.codegym.mavenbankingajax.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class ResTransferController {
    @Autowired
    private ITransferService transferService;
    @Autowired
    private ICustomerService customerService;


    @GetMapping
    public ResponseEntity<List<?>> listTransfer(){
        List<Transfer> transferList = (List<Transfer>) transferService.findAll();
        List<TransferDTO> transferDTOS = new ArrayList<>();
        for (Transfer transfer : transferList){
            transferDTOS.add(transfer.transferDTO());
        }
        return new ResponseEntity<>(transferDTOS, HttpStatus.OK);
    }
    //transfer from transferDTO
    @PostMapping()
    public ResponseEntity<List<?>> doTransferFromTransferDTO(@RequestBody TransferDTO transferDTO) {
        Customer sender = customerService.findById(transferDTO.getSenderId()).get();
        Customer recipient = customerService.findById(transferDTO.getRecipientId()).get();
        if (sender.getBalance().compareTo(transferDTO.getTotalTransfer()) >= 0) {
            Transfer transfer = transferDTO.toTransfer(sender, recipient);
           try{
               TransferDTO newTransferDTO = customerService.doTransfer(transferDTO);
           }catch (Exception e){
               List<String> error = new ArrayList<>();
               error.add("Please contact to administrator");
               return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
           }
            transferService.save(transfer);
            sender = customerService.findById(transferDTO.getSenderId()).get();
            recipient = customerService.findById(transferDTO.getRecipientId()).get();
            List<CustomerDTO> list = new ArrayList<>();
            list.add(sender.toCustomerDTO());
            list.add(recipient.toCustomerDTO());
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
