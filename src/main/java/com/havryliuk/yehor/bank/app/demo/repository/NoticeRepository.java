package com.havryliuk.yehor.bank.app.demo.repository;

import com.havryliuk.yehor.bank.app.demo.model.entity.Notice;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    List<Notice> findByBegDateLessThanAndEndDateGreaterThan(LocalDate minDate, LocalDate maxDate);

}
