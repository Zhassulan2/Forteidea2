package com.fortebank.forteidea.entity.experience.revizorro;

import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.entity.experience.Filial;
import com.fortebank.forteidea.entity.User;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "revizorro_experience")
public class RevizorroExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "branch")
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "filial")
    private Filial filial;

    @Column
    private Timestamp initDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "initiator") //initiator
    private User initiator;

    @Column
    private boolean active;

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

    public Timestamp getInitDate() {
        return initDate;
    }

    public void setInitDate(Timestamp initDate) {
        this.initDate = initDate;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
