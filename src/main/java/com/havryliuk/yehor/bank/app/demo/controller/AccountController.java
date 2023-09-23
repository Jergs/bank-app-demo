package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.AccountDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.AccountService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    @Secured("ROLE_USER")
    public ResponseEntity<AccountDetailsResponse> getAccountDetails(@RequestParam @NotBlank String email) {
        var response = accountService.getAccountDetails(email);
        return ResponseEntity.ok(response);
    }
}
