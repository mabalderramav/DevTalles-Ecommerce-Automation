package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.servicies;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginRequestDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginResponseDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers.config.MapperConfig;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.LoginRepository;
import org.modelmapper.ModelMapper;

public record LoginServiceImpl(LoginRepository loginRepository) implements LoginService {
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        ModelMapper mapper = MapperConfig.modelMapperDefault();
        LoginRequestEntity loginRequestEntity = mapper.map(loginRequestDto, LoginRequestEntity.class);
        LoginResponseEntity loginResponseEntity = loginRepository.login(loginRequestEntity);

        return mapper.map(loginResponseEntity, LoginResponseDto.class);
    }
}
