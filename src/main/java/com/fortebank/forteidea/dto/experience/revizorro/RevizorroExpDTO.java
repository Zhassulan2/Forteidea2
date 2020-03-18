package com.fortebank.forteidea.dto.experience.revizorro;

import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.dto.UserDTO;

import java.sql.Timestamp;
import java.util.List;

public class RevizorroExpDTO{
    private Long id;
    private Long branch;
    private Long filial;
    private Timestamp initDate;
    private UserDTO initiator;
    private List<CategoryWithAnswersDTO> categories;

    public RevizorroExpDTO() {
    }

    public RevizorroExpDTO(Long id, Long branch, Long filial, Timestamp initDate, UserDTO initiator, List<CategoryWithAnswersDTO> categories) {
        this.id = id;
        this.branch = branch;
        this.filial = filial;
        this.initDate = initDate;
        this.initiator = initiator;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranch() {
        return branch;
    }

    public void setBranch(Long branch) {
        this.branch = branch;
    }

    public Long getFilial() {
        return filial;
    }

    public void setFilial(Long filial) {
        this.filial = filial;
    }

    public String getInitDate() {
        if (initDate != null) {
            java.sql.Timestamp date = Timestamp.valueOf(initDate.toLocalDateTime());
            return date.toString().substring(0, 19);
        }
        return null;
    }

    public void setInitDate(Timestamp initDate) {
        this.initDate = initDate;
    }

    public UserDTO getInitiator() {
        return initiator;
    }

    public void setInitiator(UserDTO initiator) {
        this.initiator = initiator;
    }

    public List<CategoryWithAnswersDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryWithAnswersDTO> categories) {
        this.categories = categories;
    }
}
