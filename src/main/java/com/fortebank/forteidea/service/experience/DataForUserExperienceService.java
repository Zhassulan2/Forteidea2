package com.fortebank.forteidea.service.experience;

import com.fortebank.forteidea.dto.experience.DataForUserExperienceDTO;
import com.fortebank.forteidea.service.experience.client.OrderTypeWithOperationsService;
import com.fortebank.forteidea.service.experience.revizorro.RECategoryWithQuestionsService;
import com.fortebank.forteidea.util.ResponseStatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataForUserExperienceService {
    @Autowired
    private BranchService branchService;

    @Autowired
    private FilialService filialService;

    @Autowired
    private OrderTypeWithOperationsService orderTypeWithOperationsService;

    @Autowired
    private RECategoryWithQuestionsService categoryWithQuestionsService;

    public DataForUserExperienceDTO getData(){
        DataForUserExperienceDTO data = null;
        try {
            data = new DataForUserExperienceDTO(branchService.getAllActiveBranches(),
                    filialService.getAllActiveFilials(), orderTypeWithOperationsService.findTypesWithOperations(), categoryWithQuestionsService.findCategoriesWithQuestions());
            data.setCode(0);
            data.setMessage("OK");
        } catch (Exception e){
            data.setCode(ResponseStatusConstant.DATA_FOR_USER_EXP_EXCEPTION_CODE);
            data.setMessage(e.getMessage());
        }
        return data;
    }
}
