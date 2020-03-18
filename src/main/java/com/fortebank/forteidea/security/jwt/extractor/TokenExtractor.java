package com.fortebank.forteidea.security.jwt.extractor;

public interface TokenExtractor {
    String extract(String payload);
}
