package com.demo.jwt.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserRequest implements Serializable {
    @ApiModelProperty(position = 0)
    private String username;

    @ApiModelProperty(position = 1)
    private String password;

    @ApiModelProperty(position = 2,hidden = true)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
