package com.havryliuk.yehor.mobilebankdemo.controller;

import com.havryliuk.yehor.mobilebankdemo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.mobilebankdemo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody NewCustomerRequest request) {
        customerService.registerUser(request);
        return ResponseEntity.ok().build();
    }
}
