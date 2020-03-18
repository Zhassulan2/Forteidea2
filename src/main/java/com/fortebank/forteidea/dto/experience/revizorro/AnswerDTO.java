package com.fortebank.forteidea.dto.experience.revizorro;

public class AnswerDTO {
    private Long id;
    private Long questionId;
    private String answer;

    public AnswerDTO() {
    }

    public AnswerDTO(Long id, Long questionId, String answer) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
