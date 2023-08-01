package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCustomerIdOrderByDateDesc(int customerId);

}
