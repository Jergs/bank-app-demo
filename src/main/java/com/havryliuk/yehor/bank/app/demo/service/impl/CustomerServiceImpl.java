package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.mapper.CustomerMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.CustomerRepository;
import com.havryliuk.yehor.bank.app.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerDetailsResponse getUserDetailsAfterLogin(Authentication authentication) {
        Customer customer = repository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException(format("User with name %s not found",
                        authentication.getName())));

        return CustomerMapper.INSTANCE.map(customer);
    }
}
