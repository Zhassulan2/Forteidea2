package com.fortebank.forteidea.dto.experience.client;


import com.fortebank.forteidea.entity.idea.ProcessOwner;

import java.util.List;

public class ProcessDTO {
    private Long id;
    private String name;
    private List<ProcessOwner> processOwnerList;

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
