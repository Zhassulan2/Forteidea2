package com.fortebank.forteidea.dto.experience.client;

import com.fortebank.forteidea.dto.ResponseDTO;

public class ClientExperienceCreateResponseDTO extends ResponseDTO {
    private Long clientExperienceId;

    public Long getClientExperienceId() {
        return clientExperienceId;
    }

    public void setClientExperienceId(Long clientExperienceId) {
        this.clientExperienceId = clientExperienceId;
    }
}
