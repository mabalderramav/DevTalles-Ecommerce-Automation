package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private LoginUserDto user;
    private String token;
    private String message;
}
