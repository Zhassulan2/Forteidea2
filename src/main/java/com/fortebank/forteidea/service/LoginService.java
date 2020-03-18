package com.fortebank.forteidea.service;

import com.fortebank.forteidea.dto.LoginRequestDTO;
import com.fortebank.forteidea.dto.LoginResponseDTO;
import com.fortebank.forteidea.util.ResponseStatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class LoginService {
    @Autowired
    private LoginResponseDTO loginResponseDTO;

    public LoginResponseDTO authorize(LoginRequestDTO loginRequestDTO) {
        if ((loginRequestDTO.getUsername().equals("admin") && loginRequestDTO.getPassword().equals("123456")) || (loginRequestDTO.getUsername().equals("MKuzhaniyazova") && loginRequestDTO.getPassword().equals("Wersdf!2"))) {
            loginResponseDTO.setCode(ResponseStatusConstant.SUCCESS_CODE);
            loginResponseDTO.setMessage(ResponseStatusConstant.SUCCESS_MESSAGE);
            loginResponseDTO.setToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJta3V6aGFuaXlhem92YSIsInNjb3BlcyI6WyJST0xFX1dNX0RFVkVMT1BFUlMiLCJST0xFX0ZPUlRFSURFQV9BRE1JTklTVFJBVE9SUyIsIlJPTEVfV01QQ19ERVZFTE9QRVJTIiwiUk9MRV9IRUFEX0lOVF9TVEQiLCJST0xFX1dNX0FETUlOX0RQQyJdLCJqdGkiOiJhODZhZTU3NS1mMjllLTQ5NWYtYWIxMi0zZDQyMTZmNTAxYTYiLCJpYXQiOjE1ODAzNTgyMTUsImV4cCI6MTU4MDM2MTgxNX0.oVV8OhPpgEdOLa37N8eRq5NgmfynkkHxvRZZTgK_VmPElhmgNzkwmpZ1XKNwgRPfy9biiN4SxKBq5PbYg3krzw");
            loginResponseDTO.setRefreshToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJta3V6aGFuaXlhem92YSIsInNjb3BlcyI6WyJST0xFX1JFRlJFU0hfVE9LRU4iXSwianRpIjoiYTJiMGQ0ZDEtNTQ5Yi00NmE3LWIxMzEtY2NmMThkMGFmMjczIiwiaWF0IjoxNTgwMzU4MjE1LCJleHAiOjE1ODI5NTAyMTV9.x6rLNPiW21qWqd-q7ED5Sfm7z5hIBC5mTAJd9CN07fZnUkjDRklHPVBI6P_ItpA8PkNRyOVYxus9CHe8E5pEYQ");
        } else {
            loginResponseDTO.setCode(ResponseStatusConstant.AUTHORIZATION_ERROR_CODE);
            loginResponseDTO.setMessage(ResponseStatusConstant.AUTHORIZATION_ERROR_MESSAGE);
        }
        return loginResponseDTO;
    }
}
