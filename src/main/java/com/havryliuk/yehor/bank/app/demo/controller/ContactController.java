package com.havryliuk.yehor.bank.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @GetMapping
    public String saveContactDetails() {
        return "contact is saved to db";
    }
}
