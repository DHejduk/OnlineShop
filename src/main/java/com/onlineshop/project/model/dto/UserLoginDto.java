package com.onlineshop.project.model.dto;

import com.onlineshop.project.security.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginDto {

    @NotNull
    @NotEmpty @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;
}
