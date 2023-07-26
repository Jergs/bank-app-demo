package com.havryliuk.yehor.bank.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    @GetMapping("/details")
    public String getBalanceDetails() {
        return "balance details from db";
    }
}
