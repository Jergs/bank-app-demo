package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDetailsResponse> getCustomerDetails(Authentication authentication) {
        var response = customerService.getUserDetailsAfterLogin(authentication);
        return ResponseEntity.ok(response);
    }

}
