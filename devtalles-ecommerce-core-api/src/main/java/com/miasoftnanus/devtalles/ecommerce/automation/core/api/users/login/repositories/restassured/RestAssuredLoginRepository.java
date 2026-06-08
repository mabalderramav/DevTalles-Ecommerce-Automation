package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.restassured;

import com.miasoftnanus.automation.core.api.bootstrap.client.ClientWithoutAuthenticationRequestManager;
import com.miasoftnanus.automation.core.api.bootstrap.client.RequestManager;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginRequestEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities.LoginResponseEntity;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.repositories.LoginRepository;

import java.util.HashMap;
import java.util.Map;

import static com.miasoftnanus.automation.core.utils.json.JsonParser.fromJsonString;

public class RestAssuredLoginRepository implements LoginRepository {
    private final RequestManager requestManager;

    public RestAssuredLoginRepository() {
        this.requestManager = new ClientWithoutAuthenticationRequestManager();
    }

    @Override
    public LoginResponseEntity login(LoginRequestEntity loginRequestEntity) {
        String endpoint = "http://68.183.23.48:8100/api/Users/Login";
        String bodyRequest = """
                {
                  "password": "%s",
                  "username": "%s"
                }
                """.formatted(loginRequestEntity.password(), loginRequestEntity.username());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.body(bodyRequest);
        apiRequest.headers(headers);

        ApiResponse apiResponse = requestManager.post(apiRequest, endpoint);
        var statusCode = apiResponse.statusCode();
        var body = apiResponse.body();

        return fromJsonString(apiResponse.body(), LoginResponseEntity.class);
    }
}
