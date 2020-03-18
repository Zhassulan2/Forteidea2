package com.fortebank.forteidea.dto.idea;

public class IdeaBodyRequestDTO {
    private String title;
    private String initiator;
    private Long leanManager;
    private Long responsible;
    private Long process;
    private String publicationDate; //Timestamp
    private int savedHours;
    private int savedMoney;
    private String state;
    private String body;
    private String aimedResult;
    private String expectedResult;
    private String deadLine; //Timestamp

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Long getLeanManager() {
        return leanManager;
    }

    public void setLeanManager(Long leanManager) {
        this.leanManager = leanManager;
    }

    public Long getResponsible() {
        return responsible;
    }

    public void setResponsible(Long responsible) {
        this.responsible = responsible;
    }

    public Long getProcess() {
        return process;
    }

    public void setProcess(Long process) {
        this.process = process;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getSavedHours() {
        return savedHours;
    }

    public void setSavedHours(int savedHours) {
        this.savedHours = savedHours;
    }

    public int getSavedMoney() {
        return savedMoney;
    }

    public void setSavedMoney(int savedMoney) {
        this.savedMoney = savedMoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAimedResult() {
        return aimedResult;
    }

    public void setAimedResult(String aimedResult) {
        this.aimedResult = aimedResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
