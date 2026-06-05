package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String role;
    private Boolean isActive;
}
