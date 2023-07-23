package com.havryliuk.yehor.mobilebankdemo.service.impl;

import com.havryliuk.yehor.mobilebankdemo.mapper.CustomerMapper;
import com.havryliuk.yehor.mobilebankdemo.model.entity.Customer;
import com.havryliuk.yehor.mobilebankdemo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.mobilebankdemo.repository.CustomerRepository;
import com.havryliuk.yehor.mobilebankdemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Transactional
    public void registerUser(NewCustomerRequest request) {
        log.debug("Register new user request: {}", request);
        Customer customer = CustomerMapper.toCustomer(request);
        var savedCustomer = repository.save(customer);
        log.debug("Saved new user: {}", savedCustomer);
    }
}
