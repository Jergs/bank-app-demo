package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(int customerId);

    @Query("select acc"
            + " from Account acc"
            + " join Customer c on acc.customerId = c.customerId"
            + " where c.email = ?1")
    Optional<Account> findByEmail(String email);

}
