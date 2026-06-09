package com.miasoftnanus.devtalles.ecommerce.automation.api.test.users.login;

import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginRequestDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.dtos.LoginResponseDto;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.servicies.LoginService;
import com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.servicies.LoginServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@Log4j2
@DisplayName("User -> Login")
@Tag("devtalles-ecommerce-api-test")
@Tag("LoginTest")
final class LoginTest {
    @Test
    @DisplayName("C10000001: Login in the WebApp with valid credentials")
    @Tag("regression")
    @Tag("smoke")
    @Tag("C10000001")
    void C10000001LoginInTheWebAppWithValidCredentials() {
        log.info("Starting test C10000001LoginInTheWebAppWithValidCredentials");
        String usernameExpected = "ombalderramav";
        String passwordExpected = "$Oscar123$5";
        String nameExpected = "Oscar Martin Balderrama Vaca";
        String roleExpected = "Admin";
        Boolean isActiveExpected = true;
        String messageExpected = "Login successfully";
        LoginRequestDto loginRequestDto = new LoginRequestDto(usernameExpected, passwordExpected);
        LoginService loginService = new LoginServiceImpl();

        log.info("Executing login with valid credentials");
        log.info("Login request: username={}, password=********", usernameExpected);
        log.debug("Login request details: {}", loginRequestDto);
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);
        Integer idActual = loginResponseDto.user().id();
        String usernameActual = loginResponseDto.user().username();
        String nameActual = loginResponseDto.user().name();
        String roleActual = loginResponseDto.user().role();
        Boolean isActiveActual = loginResponseDto.user().isActive();
        String tokenActual = loginResponseDto.token();
        String messageActual = loginResponseDto.message();

        log.info("Login response: {}", loginResponseDto);
        log.debug("Login response details: ID={}, Username={}, Name={}, Role={}, IsActive={}, Token={}, Message={}",
                idActual, usernameActual, nameActual, roleActual, isActiveActual, tokenActual, messageActual);

        // Then
        assertSoftly(softly -> {
            softly.assertThat(idActual)
                    .as("User ID should be null for successful login")
                    .isNull();

            softly.assertThat(usernameActual)
                    .as("Username should match the expected value")
                    .isEqualTo(usernameExpected);

            softly.assertThat(passwordExpected)
                    .as("Password should not be null for successful login")
                    .isNotNull();

            softly.assertThat(nameActual)
                    .as("Name should match the expected value")
                    .isEqualTo(nameExpected);

            softly.assertThat(roleActual)
                    .as("Role should match the expected value")
                    .isEqualTo(roleExpected);

            softly.assertThat(isActiveActual)
                    .as("Active status should match the expected value")
                    .isEqualTo(isActiveExpected);

            softly.assertThat(tokenActual)
                    .as("Token should not be null for successful login")
                    .isNotNull();

            softly.assertThat(messageActual)
                    .as("Message should match the expected value")
                    .isEqualTo(messageExpected);
        });

        log.info("Login test completed successfully");
    }
}
