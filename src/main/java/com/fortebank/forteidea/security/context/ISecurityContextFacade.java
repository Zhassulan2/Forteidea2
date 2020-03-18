package com.fortebank.forteidea.security.context;

import org.springframework.security.core.userdetails.UserDetails;

public interface ISecurityContextFacade {
    UserDetails getActiveUser();
}
