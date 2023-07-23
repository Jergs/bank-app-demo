package com.havryliuk.yehor.mobilebankdemo.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewCustomerRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String pwd;
    @NotBlank
    private String role;

}
