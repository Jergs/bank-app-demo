package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.BalanceDetailsResponse;

public interface BalanceService {

    BalanceDetailsResponse getBalanceByAccountNumber(Integer id);

}
