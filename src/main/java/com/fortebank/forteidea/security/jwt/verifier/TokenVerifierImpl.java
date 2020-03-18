package com.fortebank.forteidea.security.jwt.verifier;

import com.fortebank.forteidea.security.jwt.storage.TokenStore;
import org.springframework.stereotype.Component;

@Component
public class TokenVerifierImpl implements TokenVerifier {
    private final TokenStore invalidTokenStore;

    public TokenVerifierImpl(TokenStore invalidTokenStore) {
        this.invalidTokenStore = invalidTokenStore;
    }

    @Override
    public boolean verify(String jti) {
        return !invalidTokenStore.isPresent(jti);
    }
}
