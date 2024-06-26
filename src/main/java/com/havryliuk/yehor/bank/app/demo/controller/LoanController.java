package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.LoanDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.LoanService;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    @Secured("ROLE_USER")
    public ResponseEntity<List<LoanDetailsResponse>> getLoanDetails(@RequestParam @NotBlank String email) {
        var response = loanService.getLoansByCustomerEmail(email);
        return ResponseEntity.ok(response);
    }
}
