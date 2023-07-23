package com.havryliuk.yehor.mobilebankdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    @GetMapping("/details")
    public String getCardDetails() {
        return "card details from db";
    }
}
