package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Loan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByCustomerIdOrderByStartDateDesc(int customerId);

}
