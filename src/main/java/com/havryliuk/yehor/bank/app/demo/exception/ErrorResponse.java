package com.havryliuk.yehor.bank.app.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private Integer code;
    private String message;
    private String cause;
}
