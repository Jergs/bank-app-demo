package com.havryliuk.yehor.bank.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/details")
    public String getAccountDetails() {
        return "account details from db";
    }
}
