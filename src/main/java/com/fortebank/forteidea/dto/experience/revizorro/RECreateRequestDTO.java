package com.fortebank.forteidea.dto.experience.revizorro;

import java.util.List;

public class RECreateRequestDTO extends REBodyRequestDTO {
    private List<RECreateAnswerDTO> answers;

    public List<RECreateAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<RECreateAnswerDTO> answers) {
        this.answers = answers;
    }
}

