package com.fortebank.forteidea.dto.experience.revizorro;

public class RECreateAnswerDTO {
    private Long questionId;
    private String answer;

    public RECreateAnswerDTO() {
    }

    public RECreateAnswerDTO(Long questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
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
