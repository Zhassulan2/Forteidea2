package com.fortebank.forteidea.entity.experience.revizorro;

import javax.persistence.*;

@Entity
@Table(name = "revizorro_experience_answers")
public class RevizorroExpAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "revizorro_experience_id")
    private RevizorroExperience revizorroExperience;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private RevizorroExpQuestion question;

    @Column
    private String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RevizorroExperience getRevizorroExperience() {
        return revizorroExperience;
    }

    public void setRevizorroExperience(RevizorroExperience revizorroExperience) {
        this.revizorroExperience = revizorroExperience;
    }

    public RevizorroExpQuestion getQuestion() {
        return question;
    }

    public void setQuestion(RevizorroExpQuestion question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
