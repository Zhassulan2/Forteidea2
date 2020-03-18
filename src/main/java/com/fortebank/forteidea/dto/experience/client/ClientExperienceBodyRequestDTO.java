package com.fortebank.forteidea.dto.experience.client;

public class ClientExperienceBodyRequestDTO {
    private Long id;
    private Long branch;
    private Long filial;
    private String orderType;
    private Long operation;
    private String experience;
    private String problem;
    private String initDate;
    private String initiator;

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
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }
}
