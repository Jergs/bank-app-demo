package com.havryliuk.yehor.bank.app.demo.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardDetailsResponse {

    private String cardNumber;
    private Integer customerId;
    private String type;
    private Integer totalLimit;
    private Integer amountUsed;
    private Integer availableAmount;

}
