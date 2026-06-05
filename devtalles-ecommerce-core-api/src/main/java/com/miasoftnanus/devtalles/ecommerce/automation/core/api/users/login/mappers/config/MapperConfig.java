package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.mappers.config;

import org.modelmapper.ModelMapper;

public class MapperConfig {

    private MapperConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static ModelMapper modelMapperDefault() {
        return new ModelMapper();
    }
}
