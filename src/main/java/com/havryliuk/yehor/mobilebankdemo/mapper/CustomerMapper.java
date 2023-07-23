package com.havryliuk.yehor.mobilebankdemo.mapper;

import com.havryliuk.yehor.mobilebankdemo.model.entity.Customer;
import com.havryliuk.yehor.mobilebankdemo.model.request.NewCustomerRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMapper {

    public static Customer toCustomer(NewCustomerRequest request) {
        return Customer.builder()
                .email(request.getEmail())
                .pwd(request.getPwd())
                .role(request.getRole())
                .build();
    }
}
