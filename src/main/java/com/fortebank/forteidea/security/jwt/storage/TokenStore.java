package com.fortebank.forteidea.security.jwt.storage;


import com.fortebank.forteidea.security.jwt.token.JwtToken;

public interface TokenStore {
    void store(JwtToken jwtToken);

    JwtToken retrieve(String jti);

    boolean isPresent(String jti);

}
