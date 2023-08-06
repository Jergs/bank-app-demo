package com.havryliuk.yehor.bank.app.demo.service.impl;

import static java.lang.String.format;

import com.havryliuk.yehor.bank.app.demo.mapper.BalanceMapper;
import com.havryliuk.yehor.bank.app.demo.model.response.BalanceDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.BalanceRepository;
import com.havryliuk.yehor.bank.app.demo.service.BalanceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository repository;

    public BalanceDetailsResponse getBalanceByAccountNumber(Integer id) {
        var balance = repository.findByAccountNumber(id).orElseThrow(
            () -> new EntityNotFoundException(format("No balance found by customer with id %d", id)));
        log.debug("Found balance for customer with id {}", id);

        return BalanceMapper.INSTANCE.map(balance);
    }
}
