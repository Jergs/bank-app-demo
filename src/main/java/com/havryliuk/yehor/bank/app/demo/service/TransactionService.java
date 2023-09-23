package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.TransactionDetailsResponse;
import java.util.List;

public interface TransactionService {

    List<TransactionDetailsResponse> getTransactionsByCustomerEmail(String email);
}
