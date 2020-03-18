package com.fortebank.forteidea.entity.experience.revizorro;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Scope("prototype")
@Table(name = "revizorro_experience_questions")
public class RevizorroExpQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private RevizorroExpCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public RevizorroExpCategory getCategory() {
        return category;
    }

    public void setCategory(RevizorroExpCategory category) {
        this.category = category;
    }
}
