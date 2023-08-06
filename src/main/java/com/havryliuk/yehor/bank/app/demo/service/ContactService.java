package com.havryliuk.yehor.bank.app.demo.service;

import com.havryliuk.yehor.bank.app.demo.model.dto.ContactDetailsDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContactService {

    ContactDetailsDto saveContactInquiryDetails(@RequestParam ContactDetailsDto request);

}
