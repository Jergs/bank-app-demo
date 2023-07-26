package com.havryliuk.yehor.bank.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")
public class NoticeController {

    @GetMapping
    public String getNoticeDetails() {
        return "notice details from db";
    }
}
