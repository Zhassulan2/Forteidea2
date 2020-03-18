package com.fortebank.forteidea.dto.experience.revizorro;

public class REUpdateAnswerDTO {
    private Long answerId;
    private String answer;

    public REUpdateAnswerDTO() {
    }

    public REUpdateAnswerDTO(Long answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
