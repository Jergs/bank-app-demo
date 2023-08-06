package com.havryliuk.yehor.bank.app.demo.model.response;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDetailsResponse {

    private String summary;
    private String details;
    private LocalDate begDate;
    private LocalDate endDate;

}
