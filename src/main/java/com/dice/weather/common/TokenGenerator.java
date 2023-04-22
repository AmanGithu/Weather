package com.dice.weather.common;

import java.util.UUID;

public class TokenGenerator {
    public String generateClintId() {
        return UUID.randomUUID().toString();
    }

    public String generateClintSecret() {
        return UUID.randomUUID().toString();
    }
}
