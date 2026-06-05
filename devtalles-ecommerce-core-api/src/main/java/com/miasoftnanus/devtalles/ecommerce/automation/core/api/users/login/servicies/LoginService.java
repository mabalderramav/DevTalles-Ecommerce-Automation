package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.servicies;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginRequestDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginResponseDto;

public interface LoginService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
