package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCustomerId(int customerId);

}
