package com.codegym.mavenbanking.controller;

import com.codegym.mavenbanking.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private ITransferService transferService;
}
