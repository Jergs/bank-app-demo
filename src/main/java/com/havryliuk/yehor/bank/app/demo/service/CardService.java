package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.CardDetailsResponse;
import java.util.List;

public interface CardService {

    List<CardDetailsResponse> getCardsByCustomerEmail(String email);
}
