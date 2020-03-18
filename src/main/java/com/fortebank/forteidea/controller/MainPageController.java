package com.fortebank.forteidea.controller;

import com.fortebank.forteidea.dto.LoginRequestDTO;
import com.fortebank.forteidea.dto.LoginResponseDTO;
import com.fortebank.forteidea.dto.MainPageResponseDTO;
import com.fortebank.forteidea.dto.experience.client.ProcessWithOwnersDTO;
import com.fortebank.forteidea.service.LoginService;
import com.fortebank.forteidea.service.MainPageDataService;
import com.fortebank.forteidea.service.idea.ProcessWithOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forteidea")
public class MainPageController {
    @Autowired
    private MainPageDataService mainPageDataService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProcessWithOwnerService processWithOwnerService;

    @GetMapping("/main")
    public MainPageResponseDTO countSessions(){
        return mainPageDataService.getData();
    }

    @PostMapping(path= "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return loginService.authorize(loginRequestDTO);
    }

    @GetMapping("/process")
    public List<ProcessWithOwnersDTO> showProcesses(){
        return processWithOwnerService.getProcessesWithOwners();
    }

}
