package com.fortebank.forteidea.security.jwt.token;

public enum Scope {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
