package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT DISTINCT customer FROM Customer customer " +
            "JOIN FETCH customer.authorities authorities "
            + "WHERE customer.email = ?1")
    Optional<Customer> findByEmailWithAuthorities(String email);

    Optional<Customer> findByEmail(String email);

}
