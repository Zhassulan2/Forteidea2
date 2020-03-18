package com.fortebank.forteidea.controller;

import com.fortebank.forteidea.dto.CreateResponseDTO;
import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.dto.experience.DataForUserExperienceDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceBodyRequestDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceCreateResponseDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceResponseDTO;
import com.fortebank.forteidea.dto.experience.client.OperationCreateRequest;
import com.fortebank.forteidea.dto.experience.revizorro.RECreateRequestDTO;
import com.fortebank.forteidea.dto.experience.revizorro.REUpdateRequestDTO;
import com.fortebank.forteidea.dto.experience.revizorro.RevizorroExperienceResponseDTO;
import com.fortebank.forteidea.service.experience.client.ClientExperienceService;
import com.fortebank.forteidea.service.experience.DataForUserExperienceService;
import com.fortebank.forteidea.service.experience.client.OrderOperationService;
import com.fortebank.forteidea.service.experience.revizorro.RevizorroExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forteidea/experience")
public class UserExperienceController {
    @Autowired
    private DataForUserExperienceService dataForUserExperienceService;

    @Autowired
    private ClientExperienceService clientExperienceService;

    @Autowired
    private RevizorroExperienceService revizorroExperienceService;

    @Autowired
    OrderOperationService orderOperationService;

    @GetMapping("/data")
    public DataForUserExperienceDTO getData() {
        return dataForUserExperienceService.getData();
    }


    @GetMapping("/client")
    public ClientExperienceResponseDTO getClientExperience() {
        return clientExperienceService.getAll();
    }

    @PostMapping(path = "/client/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClientExperienceCreateResponseDTO addClientExperience(@RequestBody ClientExperienceBodyRequestDTO clientExperienceBodyRequestDTO) {
        return clientExperienceService.addExperience(clientExperienceBodyRequestDTO);
    }

    @PostMapping(path = "/client/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDTO updateClientExperience(@PathVariable Long id, @RequestBody ClientExperienceBodyRequestDTO clientExperienceBodyRequestDTO) {
        return clientExperienceService.updateExperience(id, clientExperienceBodyRequestDTO);
    }

    @PostMapping(path = "/client/operation/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreateResponseDTO addOperation(@RequestBody OperationCreateRequest operation) {
        return orderOperationService.addOperation(operation);
    }

    @GetMapping("/revizorro")
    public RevizorroExperienceResponseDTO getRevizzorroExperience() {
        return revizorroExperienceService.getRevizorroExp();
    }

    @PostMapping(path = "/revizorro/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreateResponseDTO addOperation(@RequestBody RECreateRequestDTO reCreateRequestDTO) {
        return revizorroExperienceService.addRevizorroExperience(reCreateRequestDTO);
    }

    @PostMapping(path = "/revizorro/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDTO addOperation(@PathVariable Long id, @RequestBody REUpdateRequestDTO reUpdateRequestDTO) {
        return revizorroExperienceService.updateRevizorroExperience(id, reUpdateRequestDTO);
    }
}
