package com.fortebank.forteidea.dto.experience.revizorro;

public abstract class REBodyRequestDTO {
    private Long branch;
    private Long filial;
    private String initDate;
    private String initiator;

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
