package com.fortebank.forteidea.dto.experience.revizorro;

import java.util.List;

public class RECategoryWithQuestionsDTO {
    private Long id;
    private String name;
    private List<RevizorroExpQuestionDTO> questions;

    public RECategoryWithQuestionsDTO(Long id, String name, List<RevizorroExpQuestionDTO> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public RECategoryWithQuestionsDTO() {
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

    public List<RevizorroExpQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<RevizorroExpQuestionDTO> questions) {
        this.questions = questions;
    }
}
