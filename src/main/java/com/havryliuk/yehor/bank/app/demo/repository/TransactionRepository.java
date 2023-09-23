package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCustomerIdOrderByDateDesc(int customerId);

    @Query("select t "
            + "from Transaction t"
            + " join Customer c on t.customerId = c.customerId"
            + " where c.email = ?1"
            + " order by t.date desc")
    List<Transaction> findByEmailOrderByStartDateDesc(String email);


}
