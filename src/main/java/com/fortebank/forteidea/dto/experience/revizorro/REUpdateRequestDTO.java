package com.fortebank.forteidea.dto.experience.revizorro;

import java.util.List;

public class REUpdateRequestDTO extends REBodyRequestDTO {
    private List<REUpdateAnswerDTO> answers;

    public List<REUpdateAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<REUpdateAnswerDTO> answers) {
        this.answers = answers;
    }
}

