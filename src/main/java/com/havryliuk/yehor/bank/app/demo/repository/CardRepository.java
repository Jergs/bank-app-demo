package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCustomerId(int customerId);

    @Query("select cr"
            + " from Card cr"
            + " join Customer c on cr.customerId = c.customerId"
            + " where c.email = ?1")
    List<Card> findByEmail(String email);

}
