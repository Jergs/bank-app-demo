package com.havryliuk.yehor.bank.app.demo.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailsResponse {

    private String name;
    private String email;
    private String mobileNumber;

}
