package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginResponseDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginUserDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginUserEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

public final class LoginResponseMapperConfig {
    private LoginResponseMapperConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static ModelMapper loginResponseMapper() {
        ModelMapper mapper = new ModelMapper();
        Converter<LoginUserEntity, LoginUserDto> loginUserDtoConverter =
                context -> context.getSource() == null
                        ? null
                        : mapper.map(context.getSource(), LoginUserDto.class);
        Converter<LoginUserDto, LoginUserEntity> loginUserEntityConverter =
                context -> context.getSource() == null
                        ? null
                        : mapper.map(context.getSource(), LoginUserEntity.class);

        // Read
        mapper.createTypeMap(LoginUserEntity.class, LoginUserDto.class)
                .addMapping(LoginUserEntity::id, (dto, value) -> dto.id((Integer) value))
                .addMapping(LoginUserEntity::username, (dto, value) -> dto.username((String) value))
                .addMapping(LoginUserEntity::password, (dto, value) -> dto.password((String) value))
                .addMapping(LoginUserEntity::name, (dto, value) -> dto.name((String) value))
                .addMapping(LoginUserEntity::role, (dto, value) -> dto.role((String) value))
                .addMapping(LoginUserEntity::isActive, (dto, value) -> dto.isActive((Boolean) value));

        mapper.createTypeMap(LoginResponseEntity.class, LoginResponseDto.class)
                .addMappings(mapping -> {
                    mapping.using(loginUserDtoConverter)
                            .map(LoginResponseEntity::user,
                                    (dto, value) -> dto.user((LoginUserDto) value));
                    mapping.map(LoginResponseEntity::token,
                            (dto, value) -> dto.token((String) value));
                    mapping.map(LoginResponseEntity::message,
                            (dto, value) -> dto.message((String) value));
                });

        // Write
        mapper.createTypeMap(LoginUserDto.class, LoginUserEntity.class)
                .addMapping(LoginUserDto::id,
                        (entity, value) -> entity.id((Integer) value))
                .addMapping(LoginUserDto::username,
                        (entity, value) -> entity.username((String) value))
                .addMapping(LoginUserDto::password,
                        (entity, value) -> entity.password((String) value))
                .addMapping(LoginUserDto::name,
                        (entity, value) -> entity.name((String) value))
                .addMapping(LoginUserDto::role,
                        (entity, value) -> entity.role((String) value))
                .addMapping(LoginUserDto::isActive,
                        (entity, value) -> entity.isActive((Boolean) value));

        mapper.createTypeMap(LoginResponseDto.class, LoginResponseEntity.class)
                .addMappings(mapping -> {
                    mapping.using(loginUserEntityConverter)
                            .map(LoginResponseDto::user,
                                    (entity, value) -> entity.user((LoginUserEntity) value));
                    mapping.map(LoginResponseDto::token,
                            (entity, value) -> entity.token((String) value));
                    mapping.map(LoginResponseDto::message,
                            (entity, value) -> entity.message((String) value));
                });

        return mapper;
    }
}
