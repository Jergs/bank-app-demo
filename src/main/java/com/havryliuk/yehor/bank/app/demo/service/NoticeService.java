package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.response.NoticeDetailsResponse;
import java.util.List;

public interface NoticeService {

    List<NoticeDetailsResponse> getActiveNotices();
}
