package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.mapper.AccountMapper;
import com.havryliuk.yehor.bank.app.demo.model.response.AccountDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.AccountRepository;
import com.havryliuk.yehor.bank.app.demo.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountDetailsResponse getAccountDetails(Integer id) {
        var account = repository.findByCustomerId(id).orElseThrow(
            () -> new EntityNotFoundException(format("No account found by id %d", id)));
        log.debug("Found account with id {}", id);

        return AccountMapper.INSTANCE.map(account);
    }
}
