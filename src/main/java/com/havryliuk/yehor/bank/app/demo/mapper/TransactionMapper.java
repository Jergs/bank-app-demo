package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.entity.Transaction;
import com.havryliuk.yehor.bank.app.demo.model.response.TransactionDetailsResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    List<TransactionDetailsResponse> map(List<Transaction> transactions);
}
