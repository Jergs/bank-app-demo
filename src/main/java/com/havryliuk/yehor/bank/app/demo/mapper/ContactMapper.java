package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.dto.ContactDetailsDto;
import com.havryliuk.yehor.bank.app.demo.model.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    Contact map(ContactDetailsDto contactDetailsDto);

    ContactDetailsDto map(Contact contact);
}
