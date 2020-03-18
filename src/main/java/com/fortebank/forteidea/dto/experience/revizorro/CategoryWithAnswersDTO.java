package com.fortebank.forteidea.dto.experience.revizorro;

import java.util.List;

public class CategoryWithAnswersDTO {
    private Long id;
    private String name;
    private List<AnswerDTO> answers;

    public CategoryWithAnswersDTO() {
    }

    public CategoryWithAnswersDTO(Long id, String name, List<AnswerDTO> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
