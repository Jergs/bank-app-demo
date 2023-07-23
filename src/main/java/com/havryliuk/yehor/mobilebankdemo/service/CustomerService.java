package com.havryliuk.yehor.mobilebankdemo.service;

import com.havryliuk.yehor.mobilebankdemo.model.request.NewCustomerRequest;

public interface CustomerService {

    void registerUser(NewCustomerRequest request);
}
