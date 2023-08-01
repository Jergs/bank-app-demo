package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.mapper.CustomerMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.CustomerRepository;
import com.havryliuk.yehor.bank.app.demo.service.CustomerService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(NewCustomerRequest request) {
        log.debug("Register new user request: {}", request);
        Optional<Customer> customerOptional = repository.findByEmail(request.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        Customer customer = CustomerMapper.INSTANCE.map(request);
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        var savedCustomer = repository.save(customer);
        log.debug("Saved new user: {}", savedCustomer);
    }


    public CustomerDetailsResponse getUserDetailsAfterLogin(Authentication authentication) {
        Customer customer = repository.findByEmail(authentication.getName())
            .orElseThrow(() -> new UsernameNotFoundException(format("User with name %s not found",
                authentication.getName())));

        return CustomerMapper.INSTANCE.map(customer);
    }

    public Customer findCustomerByUsername(String username) {
        Optional<Customer> customerOptional = repository.findByEmail(username);
        Customer customer = customerOptional.orElseThrow(
            () -> new UsernameNotFoundException("No user with this userName found"));

        log.debug("Customer found for username: {}", username);
        return customer;
    }
}
