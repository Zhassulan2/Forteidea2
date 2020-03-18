package com.fortebank.forteidea.dto.experience;

import com.fortebank.forteidea.dto.experience.client.OrderTypeWithOperationsDTO;
import com.fortebank.forteidea.dto.experience.revizorro.RECategoryWithQuestionsDTO;
import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.entity.experience.Filial;

import java.util.List;

public class DataForUserExperienceDTO extends ResponseDTO {
    private List<Branch> branches;
    private List<Filial> filials;
    private List<OrderTypeWithOperationsDTO> clientExperienceData;
    private List<RECategoryWithQuestionsDTO> revizorroExperienceData;

    public DataForUserExperienceDTO(List<Branch> branches, List<Filial> filials, List<OrderTypeWithOperationsDTO> clientExperienceData, List<RECategoryWithQuestionsDTO> revizorroExperienceData) {
        this.branches = branches;
        this.filials = filials;
        this.clientExperienceData = clientExperienceData;
        this.revizorroExperienceData = revizorroExperienceData;
    }

    public DataForUserExperienceDTO() {
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Filial> getFilials() {
        return filials;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }

    public List<OrderTypeWithOperationsDTO> getClientExperienceData() {
        return clientExperienceData;
    }

    public void setClientExperienceData(List<OrderTypeWithOperationsDTO> clientExperienceData) {
        this.clientExperienceData = clientExperienceData;
    }

    public List<RECategoryWithQuestionsDTO> getRevizorroExperienceData() {
        return revizorroExperienceData;
    }

    public void setRevizorroExperienceData(List<RECategoryWithQuestionsDTO> revizorroExperienceQuestions) {
        this.revizorroExperienceData = revizorroExperienceQuestions;
    }
}
