package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.entity.Loan;
import com.havryliuk.yehor.bank.app.demo.model.response.LoanDetailsResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    List<LoanDetailsResponse> map(List<Loan> account);
}
