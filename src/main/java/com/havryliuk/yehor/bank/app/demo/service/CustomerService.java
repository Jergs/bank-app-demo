package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import org.springframework.security.core.Authentication;

public interface CustomerService {

    void registerUser(NewCustomerRequest request);

    Customer findCustomerByUsername(String username);

    CustomerDetailsResponse getUserDetailsAfterLogin(Authentication authentication);
}
