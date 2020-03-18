package com.fortebank.forteidea.dto.experience.revizorro;

public class RevizorroExpQuestionDTO {
    private Long id;
    private String question;

    public RevizorroExpQuestionDTO(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public RevizorroExpQuestionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
