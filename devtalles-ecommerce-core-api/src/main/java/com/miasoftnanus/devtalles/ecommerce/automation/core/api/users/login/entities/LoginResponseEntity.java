package com.miasoftnanus.devtalles.ecommerce.automation.core.api.users.login.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseEntity {
    @SerializedName("user")
    @Expose
    private LoginUserEntity user;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("message")
    @Expose
    private String message;
}
