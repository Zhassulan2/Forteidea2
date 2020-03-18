package com.fortebank.forteidea.entity.idea;

import com.fortebank.forteidea.entity.User;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Scope("prototype")
@Table(name = "idea")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "initiator") //initiator
    private User initiator;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lean_manager") //lean_manager
    private ProcessOwner leanManager;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "responsible")
    private ProcessOwner responsible;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "process")
    private Process process;

    @Column
    private Timestamp publicationDate;

    @Column
    private int savedHours;

    @Column
    private int savedMoney;

    @Column
    private String state;

    @Column
    private String body;

    @Column
    private String achievedResult;

    @Column
    private String expectedResult;

    @Column
    private Timestamp deadLine;

    public Idea() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }

    public ProcessOwner getLeanManager() {
        return leanManager;
    }

    public void setLeanManager(ProcessOwner leanManager) {
        this.leanManager = leanManager;
    }

    public ProcessOwner getResponsible() {
        return responsible;
    }

    public void setResponsible(ProcessOwner responsible) {
        this.responsible = responsible;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
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

    public void setId(Long id) {
        this.id = id;
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

    public void setAchievedResult(String aimedResult) {
        this.achievedResult = aimedResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Timestamp getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Timestamp deadLine) {
        this.deadLine = deadLine;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
