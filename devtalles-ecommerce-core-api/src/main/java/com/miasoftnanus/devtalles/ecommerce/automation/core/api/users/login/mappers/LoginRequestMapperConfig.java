package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginRequestDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import org.modelmapper.ModelMapper;

public final class LoginRequestMapperConfig {
    private LoginRequestMapperConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static ModelMapper loginRequestMapper() {
        ModelMapper mapper = new ModelMapper();
        // Read
        mapper.createTypeMap(LoginRequestDto.class, LoginRequestEntity.class)
                .addMapping(LoginRequestDto::username,
                        (entity, value) -> entity.username((String) value))
                .addMapping(LoginRequestDto::password,
                        (entity, value) -> entity.password((String) value));
        // Write
        mapper.createTypeMap(LoginRequestEntity.class, LoginRequestDto.class)
                .addMapping(LoginRequestEntity::username,
                        (dto, value) -> dto.username((String) value))
                .addMapping(LoginRequestEntity::password,
                        (dto, value) -> dto.password((String) value));

        return mapper;
    }
}
