package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.LoanMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Loan;
import com.havryliuk.yehor.bank.app.demo.model.response.LoanDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.LoanRepository;
import com.havryliuk.yehor.bank.app.demo.service.LoanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;

    public List<LoanDetailsResponse> getLoansByCustomerEmail(String email) {
        var loans = repository.findByEmailOrderByStartDateDesc(email);
        log.debug("Found loans with numbers {}", loans.stream().map(Loan::getLoanNumber).toList());

        return LoanMapper.INSTANCE.map(loans);
    }
}
