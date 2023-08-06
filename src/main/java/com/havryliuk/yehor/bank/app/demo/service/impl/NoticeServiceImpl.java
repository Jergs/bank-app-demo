package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.NoticeMapper;
import com.havryliuk.yehor.bank.app.demo.model.entity.Notice;
import com.havryliuk.yehor.bank.app.demo.model.response.NoticeDetailsResponse;
import com.havryliuk.yehor.bank.app.demo.repository.NoticeRepository;
import com.havryliuk.yehor.bank.app.demo.service.NoticeService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository repository;

    public List<NoticeDetailsResponse> getActiveNotices() {
        var notices = repository.findByBegDateLessThanAndEndDateGreaterThan(LocalDate.now(), LocalDate.now());
        log.debug("Found notices with ids {}", notices.stream().map(Notice::getNoticeId).toList());

        return NoticeMapper.INSTANCE.map(notices);
    }
}
