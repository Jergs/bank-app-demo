package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.TransactionDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.TransactionService;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDetailsResponse>> getTransactionDetails(@RequestParam
                                                                                  @NotNull Integer customerId) {
        var response = transactionService.getTransactionsByCustomerId(customerId);
        return ResponseEntity.ok(response);
    }
}
