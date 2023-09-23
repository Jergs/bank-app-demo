package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Loan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select l "
            + "from Loan l"
            + " join Customer c on l.customerId = c.customerId"
            + " where c.email = ?1"
            + " order by l.startDate desc")
    List<Loan> findByEmailOrderByStartDateDesc(String email);

}
