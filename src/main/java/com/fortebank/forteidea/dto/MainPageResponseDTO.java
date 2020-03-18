package com.fortebank.forteidea.dto;

import com.fortebank.forteidea.dto.experience.client.ProcessWithOwnersDTO;
import com.fortebank.forteidea.dto.idea.IdeaDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class MainPageResponseDTO extends ResponseDTO {
    private int visitCounts;
    private List<IdeaDTO> ideas;
    private List<ProcessWithOwnersDTO> processes;

    public int getVisitCounts() {
        return visitCounts;
    }

    public void setVisitCounts(int visitCounts) {
        this.visitCounts = visitCounts;
    }

    public List<IdeaDTO> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<IdeaDTO> ideas) {
        this.ideas = ideas;
    }

    public List<ProcessWithOwnersDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ProcessWithOwnersDTO> processes) {
        this.processes = processes;
    }
}
