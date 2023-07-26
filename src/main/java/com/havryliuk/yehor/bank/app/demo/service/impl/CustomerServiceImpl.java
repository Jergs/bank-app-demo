package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.repository.CustomerRepository;
import com.havryliuk.yehor.bank.app.demo.service.CustomerService;
import com.havryliuk.yehor.bank.app.demo.mapper.CustomerMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;
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
        Customer customer = CustomerMapper.INSTANCE.map(request);
        var savedCustomer = repository.save(customer);
        log.debug("Saved new user: {}", savedCustomer);
    }
}
