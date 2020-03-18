package com.fortebank.forteidea.security.jwt.verifier;

public interface TokenVerifier {
    boolean verify(String jti);
}
