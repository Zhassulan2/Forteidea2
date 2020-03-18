package com.fortebank.forteidea.dto.experience.client;

public class ProcessOwnerDTO {
    private Long id;
    private String fullname;

    public ProcessOwnerDTO(Long id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
