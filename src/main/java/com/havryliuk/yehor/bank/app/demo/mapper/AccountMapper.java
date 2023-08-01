package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.entity.Account;
import com.havryliuk.yehor.bank.app.demo.model.response.AccountDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDetailsResponse map(Account account);
}
