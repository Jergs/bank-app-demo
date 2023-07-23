package com.havryliuk.yehor.mobilebankdemo.mapper;

import com.havryliuk.yehor.mobilebankdemo.model.entity.Customer;
import com.havryliuk.yehor.mobilebankdemo.model.request.NewCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer map(NewCustomerRequest request);

}
