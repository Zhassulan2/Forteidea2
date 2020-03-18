package com.fortebank.forteidea.controller;

import com.fortebank.forteidea.dto.idea.IdeaBodyRequestDTO;
import com.fortebank.forteidea.dto.CreateResponseDTO;
import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.service.idea.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forteidea/idea")
public class IdeaController {
    @Autowired
    private IdeaService ideaService;

    @PostMapping(path= "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreateResponseDTO addIdea(@RequestBody IdeaBodyRequestDTO ideaBodyRequestDTO){
        return ideaService.addIdea(ideaBodyRequestDTO);
    }

    @PostMapping(path= "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDTO editEdit(@PathVariable Long id, @RequestBody IdeaBodyRequestDTO ideaBodyRequestDTO){
        return ideaService.updateIdea(id, ideaBodyRequestDTO);
    }
}
