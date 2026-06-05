package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.restassured;

import com.miasoftnanus.automation.core.api.bootstrap.client.RequestManager;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.LoginRepository;

import static com.miasoftnanus.automation.core.utils.json.JsonParser.fromJsonString;

public record RestAssuredLoginRepository(RequestManager requestManager) implements LoginRepository {
    @Override
    public LoginResponseEntity login(LoginRequestEntity loginRequestEntity) {
        String endpoint = "/api/login";
        String bodyRequest = """
                {
                  "password": "%s",
                  "username": "%s"
                }
                """.formatted(loginRequestEntity.password(), loginRequestEntity.username());
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.body(bodyRequest);
        ApiResponse apiResponse = requestManager.post(apiRequest, endpoint);

        return fromJsonString(apiResponse.body(), LoginResponseEntity.class);
    }
}
