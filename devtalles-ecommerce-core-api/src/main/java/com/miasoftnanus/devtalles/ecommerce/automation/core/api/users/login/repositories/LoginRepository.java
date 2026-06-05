package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;

public interface LoginRepository {
    LoginResponseEntity login(LoginRequestEntity loginRequestEntity);
}
