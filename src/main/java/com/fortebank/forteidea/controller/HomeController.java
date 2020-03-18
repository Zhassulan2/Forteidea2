package com.fortebank.forteidea.controller;

import com.fortebank.forteidea.security.annotation.AllowAdmin;
import com.fortebank.forteidea.security.annotation.AllowUser;
import com.fortebank.forteidea.security.model.User;
import com.fortebank.forteidea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private UserService userService;

    @AllowUser
    @GetMapping("/higger")
    public String higger(Principal principal) {
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return String.format("Welcome Higger %s to the home page!", user.getFullname());
    }

    @AllowAdmin
    @GetMapping("/admin")
    public String admin(Principal principal) {
        return String.format("Welcome Admin %s to the home page!", principal.getName());
    }

    @AllowUser
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/whoami")
    public User user(Principal principal) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.saveUser(user);
        return user;
//        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
