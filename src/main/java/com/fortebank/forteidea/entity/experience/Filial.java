package com.fortebank.forteidea.entity.experience;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name ="filial")
@Scope("prototype")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
