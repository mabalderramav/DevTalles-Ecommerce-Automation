package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.servicies;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginRequestDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginResponseDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers.LoginRequestMapperConfig;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers.LoginResponseMapperConfig;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.LoginRepository;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.restassured.RestAssuredLoginRepository;
import org.modelmapper.ModelMapper;

public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    public LoginServiceImpl() {
        this.loginRepository = new RestAssuredLoginRepository();
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        ModelMapper mapper = LoginRequestMapperConfig.loginRequestMapper();
        LoginRequestEntity loginRequestEntity = mapper.map(loginRequestDto, LoginRequestEntity.class);
        LoginResponseEntity loginResponseEntity = loginRepository.login(loginRequestEntity);
        mapper = LoginResponseMapperConfig.loginResponseMapper();
        return mapper.map(loginResponseEntity, LoginResponseDto.class);
    }
}
