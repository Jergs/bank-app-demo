package com.havryliuk.yehor.bank.app.demo.model.response;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDetailsResponse {

    private Integer accountNumber;
    private Integer customerId;
    private LocalDate date;
    private String summary;
    private String type;
    private Integer amount;
}
