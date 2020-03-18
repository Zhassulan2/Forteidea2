package com.fortebank.forteidea.dto.experience.revizorro;

import com.fortebank.forteidea.dto.ResponseDTO;

import java.util.List;

public class RevizorroExperienceResponseDTO extends ResponseDTO {
    List<RevizorroExpDTO> revizorroExperience;

    public RevizorroExperienceResponseDTO(List<RevizorroExpDTO> revizorroExperience) {
        this.revizorroExperience = revizorroExperience;
    }

    public RevizorroExperienceResponseDTO() {
    }

    public List<RevizorroExpDTO> getRevizorroExperience() {
        return revizorroExperience;
    }

    public void setRevizorroExperience(List<RevizorroExpDTO> revizorroExperience) {
        this.revizorroExperience = revizorroExperience;
    }
}
