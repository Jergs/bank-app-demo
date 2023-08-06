package com.havryliuk.yehor.bank.app.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDetailsDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String subject;
    @NotBlank
    private String message;
}
