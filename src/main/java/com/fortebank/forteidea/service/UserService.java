package com.fortebank.forteidea.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortebank.forteidea.entity.User;
import com.fortebank.forteidea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findAllByUsername(String username){
        return userRepository.findAllByUsername(username);
    }

    public void saveUser(com.fortebank.forteidea.security.model.User ldapUser){
        User user = new User();
        user.setUsername(ldapUser.getUsername());
        user.setFullname(ldapUser.getFullname());
        user.setFirstname(ldapUser.getFirstname());
        user.setLastname(ldapUser.getLastname());
        user.setEmployeeId(ldapUser.getEmployeeId());
        user.setEmail(ldapUser.getEmail());
        user.setCompany(ldapUser.getCompany());
        user.setDepartment(ldapUser.getDepartment());
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String userUnJson = objectMapper.writeValueAsString(user);
//            System.out.println(userUnJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        userRepository.save(user);
    }
}
