package com.fortebank.forteidea.dto.experience.client;

import com.fortebank.forteidea.dto.ResponseDTO;

import java.util.List;

public class ClientExperienceResponseDTO extends ResponseDTO {
    List<ClientExperienceDTO> clientExperience;

    public List<ClientExperienceDTO> getClientExperience() {
        return clientExperience;
    }

    public void setClientExperience(List<ClientExperienceDTO> clientExperience) {
        this.clientExperience = clientExperience;
    }
}
