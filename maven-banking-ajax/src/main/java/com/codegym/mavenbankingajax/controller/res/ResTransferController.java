package com.codegym.mavenbankingajax.controller.res;

import com.codegym.mavenbankingajax.model.Transfer;
import com.codegym.mavenbankingajax.model.dto.TransferDTO;
import com.codegym.mavenbankingajax.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class ResTransferController {
    @Autowired
    private ITransferService transferService;

    @GetMapping
    public ResponseEntity<List<?>> listTransfer(){
        List<Transfer> transferList = (List<Transfer>) transferService.findAll();
        List<TransferDTO> transferDTOS = new ArrayList<>();
        for (Transfer transfer : transferList){
            transferDTOS.add(transfer.transferDTO());
        }
        return new ResponseEntity<>(transferDTOS, HttpStatus.OK);
    }
}
