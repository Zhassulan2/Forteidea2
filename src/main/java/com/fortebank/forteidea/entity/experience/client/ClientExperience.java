package com.fortebank.forteidea.entity.experience.client;

import com.fortebank.forteidea.entity.*;
import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.entity.experience.Filial;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="client_experience")
public class ClientExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "branch")
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "filial")
    private Filial filial;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_type")
    private OrderType orderType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "operation")
    private OrderOperation operation;

    @Column
    private String experience;

    @Column
    private String problem;

    @Column
    private Timestamp initDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "initiator") //initiator
    private User initiator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderOperation getOperation() {
        return operation;
    }

    public void setOperation(OrderOperation operation) {
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

    public Timestamp getInitDate() {
        return initDate;
    }

    public void setInitDate(Timestamp init_date) {
        this.initDate = init_date;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }
}
