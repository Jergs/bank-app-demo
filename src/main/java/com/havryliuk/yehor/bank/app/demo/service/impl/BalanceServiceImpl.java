package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.exception.NotFoundException;
import com.havryliuk.yehor.bank.app.demo.mapper.BalanceMapper;
import com.havryliuk.yehor.bank.app.demo.model.response.BalanceDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.BalanceRepository;
import com.havryliuk.yehor.bank.app.demo.service.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository repository;

    public BalanceDetailsResponse getBalanceByAccountNumber(Integer accountNumber) {
        var balance = repository.findByAccountNumber(accountNumber).orElseThrow(
                () -> new NotFoundException(format("No balance found by account number %d", accountNumber)));
        log.debug("Found balance for account with account number {}", accountNumber);

        return BalanceMapper.INSTANCE.map(balance);
    }
}
