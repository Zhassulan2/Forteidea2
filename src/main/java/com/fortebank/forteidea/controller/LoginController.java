package com.fortebank.forteidea.controller;

import com.fortebank.forteidea.security.annotation.AllowUser;
import com.fortebank.forteidea.security.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/forteidea")
public class LoginController {
    @AllowUser
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/login")
    public User user(Principal principal) {
        //Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getFullname());
        return user;
    }
}
