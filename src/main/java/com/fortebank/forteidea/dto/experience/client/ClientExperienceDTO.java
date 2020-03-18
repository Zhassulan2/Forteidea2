package com.fortebank.forteidea.dto.experience.client;

import com.fortebank.forteidea.dto.UserDTO;

import java.sql.Timestamp;

public class ClientExperienceDTO {
    private Long id;
    private Long branch;
    private Long filial;
    private String orderType;
    private Long operation;
    private String experience;
    private String problem;
    private Timestamp initDate;
    private UserDTO initiator;

    public ClientExperienceDTO(Long id, Long branch, Long filial, String orderType, Long operation, String experience, String problem, Timestamp initDate, UserDTO initiator) {
        this.id = id;
        this.branch = branch;
        this.filial = filial;
        this.orderType = orderType;
        this.operation = operation;
        this.experience = experience;
        this.problem = problem;
        this.initDate = initDate;
        this.initiator = initiator;
    }

    public ClientExperienceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranch() {
        return branch;
    }

    public void setBranch(Long branch) {
        this.branch = branch;
    }

    public Long getFilial() {
        return filial;
    }

    public void setFilial(Long filial) {
        this.filial = filial;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getOperation() {
        return operation;
    }

    public void setOperation(Long operation) {
        this.operation = operation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getInitDate() {
        if (initDate != null) {
            java.sql.Timestamp date = Timestamp.valueOf(initDate.toLocalDateTime());
            return date.toString().substring(0, 19);
        }
        return null;
    }

    public void setInitDate(Timestamp initDate) {
        this.initDate = initDate;
    }

    public UserDTO getInitiator() {
        return initiator;
    }

    public void setInitiator(UserDTO initiator) {
        this.initiator = initiator;
    }
}
