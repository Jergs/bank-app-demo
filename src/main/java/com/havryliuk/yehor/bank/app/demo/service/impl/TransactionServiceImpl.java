package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.TransactionMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Transaction;
import com.havryliuk.yehor.bank.app.demo.model.response.TransactionDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.TransactionRepository;
import com.havryliuk.yehor.bank.app.demo.service.TransactionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public List<TransactionDetailsResponse> getTransactionsByCustomerId(Integer id) {
        var transactions = repository.findByCustomerIdOrderByDateDesc(id);
        log.debug("Found transactions with ids {}", transactions.stream().map(Transaction::getTransactionId).toList());

        return TransactionMapper.INSTANCE.map(transactions);
    }
}
