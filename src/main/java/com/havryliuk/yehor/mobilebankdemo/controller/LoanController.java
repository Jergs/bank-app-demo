package com.havryliuk.yehor.mobilebankdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/details")
    public String getLoanDetails() {
        return "loan details from db";
    }
}
