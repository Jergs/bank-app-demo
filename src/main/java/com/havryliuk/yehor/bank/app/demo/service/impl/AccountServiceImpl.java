package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.exception.NotFoundException;
import com.havryliuk.yehor.bank.app.demo.mapper.AccountMapper;
import com.havryliuk.yehor.bank.app.demo.model.response.AccountDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.AccountRepository;
import com.havryliuk.yehor.bank.app.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountDetailsResponse getAccountDetails(String email) {
        var account = repository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(format("No account found by customer with email [%s]", email)));
        log.debug("Found account with email {}", email);

        return AccountMapper.INSTANCE.map(account);
    }
}
