package com.dice.weather.model;

public class AuthenticationResponse {
    String token;

    AuthenticationResponse() {

    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
