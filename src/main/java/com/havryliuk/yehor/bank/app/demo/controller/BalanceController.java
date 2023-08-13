package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.BalanceDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.BalanceService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public ResponseEntity<BalanceDetailsResponse> getBalanceDetails(@RequestParam @NotNull Integer accountNumber) {
        var response = balanceService.getBalanceByAccountNumber(accountNumber);
        return ResponseEntity.ok(response);
    }
}
