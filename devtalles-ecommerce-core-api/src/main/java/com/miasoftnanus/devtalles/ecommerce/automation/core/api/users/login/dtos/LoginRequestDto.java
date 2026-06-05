package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
