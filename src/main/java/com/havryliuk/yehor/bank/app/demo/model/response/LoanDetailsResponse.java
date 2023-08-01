package com.havryliuk.yehor.bank.app.demo.model.response;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoanDetailsResponse {

    private Integer loanNumber;
    private Integer customerId;
    private LocalDate startDate;
    private String type;
    private Integer total;
    private Integer amountPaid;
    private Integer outstandingAmount;

}
