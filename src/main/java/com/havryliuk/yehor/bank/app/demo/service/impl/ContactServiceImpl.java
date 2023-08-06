package com.havryliuk.yehor.bank.app.demo.service.impl;

import com.havryliuk.yehor.bank.app.demo.mapper.ContactMapper;
import com.havryliuk.yehor.bank.app.demo.model.dto.ContactDetailsDto;
import com.havryliuk.yehor.bank.app.demo.model.entity.Contact;
import com.havryliuk.yehor.bank.app.demo.repository.ContactRepository;
import com.havryliuk.yehor.bank.app.demo.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Transactional
    public ContactDetailsDto saveContactInquiryDetails(@RequestParam ContactDetailsDto request) {
        Contact contact = ContactMapper.INSTANCE.map(request);
        contact = repository.save(contact);
        log.debug("Saved new contact with id {}", contact.getContactId());

        return ContactMapper.INSTANCE.map(contact);
    }
}
