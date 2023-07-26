package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.CustomerMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.bank.app.demo.repository.CustomerRepository;
import com.havryliuk.yehor.bank.app.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(NewCustomerRequest request) {
        log.debug("Register new user request: {}", request);
        List<Customer> customerByEmail = repository.findByEmail(request.getEmail());
        if (!customerByEmail.isEmpty()) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        Customer customer = CustomerMapper.INSTANCE.map(request);
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        var savedCustomer = repository.save(customer);
        log.debug("Saved new user: {}", savedCustomer);
    }
}
