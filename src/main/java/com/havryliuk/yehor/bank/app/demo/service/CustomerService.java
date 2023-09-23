package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import org.springframework.security.core.Authentication;

public interface CustomerService {

    CustomerDetailsResponse getUserDetailsAfterLogin(Authentication authentication);
}
