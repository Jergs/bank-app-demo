package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.AccountDetailsResponse;

public interface AccountService {

    AccountDetailsResponse getAccountDetails(Integer id);
}
