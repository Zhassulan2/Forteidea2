package com.fortebank.forteidea.entity;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Scope("prototype")
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    @Column
    private String accessToken;

    @Column
    private String refreshToken;
}
