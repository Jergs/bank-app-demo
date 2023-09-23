package com.havryliuk.yehor.bank.app.demo.controller;

import com.havryliuk.yehor.bank.app.demo.model.response.CardDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.service.CardService;
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
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    @Secured("ROLE_USER")
    public ResponseEntity<List<CardDetailsResponse>> getCardDetails(@RequestParam @NotBlank String email) {
        var response = cardService.getCardsByCustomerEmail(email);
        return ResponseEntity.ok(response);
    }
}
