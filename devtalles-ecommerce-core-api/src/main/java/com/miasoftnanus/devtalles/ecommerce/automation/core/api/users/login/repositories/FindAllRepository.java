package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories;

import java.util.List;

public interface FindAllRepository<T> {
    List<T> findAll();
}
