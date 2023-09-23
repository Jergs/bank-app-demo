package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.LoanDetailsResponse;
import java.util.List;

public interface LoanService {

    List<LoanDetailsResponse> getLoansByCustomerEmail(String email);
}
