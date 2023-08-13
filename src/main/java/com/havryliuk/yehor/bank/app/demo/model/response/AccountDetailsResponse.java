package com.havryliuk.yehor.bank.app.demo.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDetailsResponse {

    private Integer accountNumber;
    private Integer customerId;
    private String accountType;
    private String branchAddress;

}
