package com.fortebank.forteidea.dto.idea;

import com.fortebank.forteidea.dto.UserDTO;

import java.sql.Timestamp;

public class IdeaDTO {
    private Long id;
    private String title;
    private UserDTO initiator;
    private UserDTO leanManager;
    private UserDTO responsible;
    private Long processId;
    private Timestamp publicationDate;
    private int savedHours;
    private int savedMoney;
    private String state;
    private String body;
    private String achievedResult;
    private String expectedResult;
    private Timestamp deadLine;
    private int likeAmount;
    private int dislikeAmount;

    public IdeaDTO() {
    }

    public IdeaDTO(Long id, String title, UserDTO initiator, UserDTO leanManager, UserDTO responsible, Long processId, Timestamp publicationDate, int savedHours, int savedMoney, String state, String body, String achievedResult, String expectedResult, Timestamp deadLine) {
        this.id = id;
        this.title = title;
        this.initiator = initiator;
        this.leanManager = leanManager;
        this.responsible = responsible;
        this.processId = processId;
        this.publicationDate = publicationDate;
        this.savedHours = savedHours;
        this.savedMoney = savedMoney;
        this.state = state;
        this.body = body;
        this.achievedResult = achievedResult;
        this.expectedResult = expectedResult;
        this.deadLine = deadLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserDTO getInitiator() {
        return initiator;
    }

    public void setInitiator(UserDTO initiator) {
        this.initiator = initiator;
    }

    public UserDTO getLeanManager() {
        return leanManager;
    }

    public void setLeanManager(UserDTO leanManager) {
        this.leanManager = leanManager;
    }

    public UserDTO getResponsible() {
        return responsible;
    }

    public void setResponsible(UserDTO responsible) {
        this.responsible = responsible;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getPublicationDate() {
        if (publicationDate != null) {
            java.sql.Timestamp date = Timestamp.valueOf(publicationDate.toLocalDateTime());
            System.out.println(date);
            return date.toString().substring(0, 19);
        }
        return null;
    }

    public void setPublicationDate(Timestamp publicationDate) {
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

    public String getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(String achievedResult) {
        this.achievedResult = achievedResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getDeadLine() {
        if (deadLine != null) {
            java.sql.Timestamp date = Timestamp.valueOf(deadLine.toLocalDateTime());
            System.out.println(date);
            return date.toString().substring(0, 19);
        }
        return null;
    }

    public void setDeadLine(Timestamp deadLine) {
        this.deadLine = deadLine;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }

    public int getDislikeAmount() {
        return dislikeAmount;
    }

    public void setDislikeAmount(int dislikeAmount) {
        this.dislikeAmount = dislikeAmount;
    }
}
