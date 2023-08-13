package com.havryliuk.yehor.bank.app.demo.mapper;

import com.havryliuk.yehor.bank.app.demo.model.entity.Customer;
import com.havryliuk.yehor.bank.app.demo.model.request.NewCustomerRequest;
import com.havryliuk.yehor.bank.app.demo.model.response.CustomerDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer map(NewCustomerRequest request);

    @Mapping(source = "customerId", target = "id")
    CustomerDetailsResponse map(Customer customer);

}
