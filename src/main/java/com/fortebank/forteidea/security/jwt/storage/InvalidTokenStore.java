package com.fortebank.forteidea.security.jwt.storage;

import com.fortebank.forteidea.security.jwt.JwtSettings;
import com.fortebank.forteidea.security.jwt.token.JwtToken;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class InvalidTokenStore implements TokenStore {

    private LoadingCache<String, JwtToken> invalidTokenCache;

    @Autowired
    public InvalidTokenStore(JwtSettings jwtSettings) {
        super();
        this.invalidTokenCache = CacheBuilder.newBuilder()
                .expireAfterWrite(jwtSettings.getTokenExpTime(), TimeUnit.SECONDS)
                .build(new CacheLoader<String, JwtToken>() {
                    @Override
                    public JwtToken load(String key) throws Exception {
                        return retrieve(key);
                    }
                });
    }

    @Override
    public void store(JwtToken jwtToken) {
        invalidTokenCache.put(jwtToken.getJti(), jwtToken);
    }

    @Override
    public JwtToken retrieve(String jti) {
        return invalidTokenCache.getIfPresent(jti);
    }

    @Override
    public boolean isPresent(String jti) {
        return invalidTokenCache.getIfPresent(jti) != null;
    }
}
