package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;

public interface CustomerService {

    void registerUser(NewCustomerRequest request);
}