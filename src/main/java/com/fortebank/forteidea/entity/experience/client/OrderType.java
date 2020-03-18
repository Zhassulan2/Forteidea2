package com.fortebank.forteidea.entity.experience.client;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Scope("prototype")
@Table(name = "order_type")
public class OrderType {
    @Id
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
