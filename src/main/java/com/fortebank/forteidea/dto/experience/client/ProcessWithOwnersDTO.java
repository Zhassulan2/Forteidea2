package com.fortebank.forteidea.dto.experience.client;


import java.util.List;

public class ProcessWithOwnersDTO{
    private Long id;
    private String name;

    private List<ProcessOwnerDTO> responsible;
    private List<ProcessOwnerDTO> leanManagers;

    public ProcessWithOwnersDTO(Long id, String name, List<ProcessOwnerDTO> responsible, List<ProcessOwnerDTO> leanManagers) {
        this.id = id;
        this.name = name;
        this.responsible = responsible;
        this.leanManagers = leanManagers;
    }

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

    public List<ProcessOwnerDTO> getResponsible() {
        return responsible;
    }

    public void setResponsible(List<ProcessOwnerDTO> responsible) {
        this.responsible = responsible;
    }

    public List<ProcessOwnerDTO> getLeanManagers() {
        return leanManagers;
    }

    public void setLeanManagers(List<ProcessOwnerDTO> leanManagers) {
        this.leanManagers = leanManagers;
    }
}
