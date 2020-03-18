package com.fortebank.forteidea.service.experience.revizorro;

import com.fortebank.forteidea.dto.experience.revizorro.RECategoryWithQuestionsDTO;
import com.fortebank.forteidea.dto.experience.revizorro.RevizorroExpQuestionDTO;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpCategory;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RECategoryWithQuestionsService {
    @Autowired
    RECategoryService categoryService;

    @Autowired
    REQuestionService questionService;

    public List<RECategoryWithQuestionsDTO> findCategoriesWithQuestions(){
        List<RECategoryWithQuestionsDTO> categoryWithQuestionsDTOList = new ArrayList<>();
        List<RevizorroExpCategory> categories = categoryService.findAllCategories();
        for (RevizorroExpCategory category : categories) {
            RECategoryWithQuestionsDTO categoryWithQuestionsDTO = new RECategoryWithQuestionsDTO(category.getId(), category.getName(),
                    mapQuestionsToDTO(questionService.findQuestionsByCategory(category)));
            categoryWithQuestionsDTOList.add(categoryWithQuestionsDTO);
        }
        return categoryWithQuestionsDTOList;
    }

    private List<RevizorroExpQuestionDTO> mapQuestionsToDTO(List<RevizorroExpQuestion> questions){
        List<RevizorroExpQuestionDTO> questionDTOList = new ArrayList<>();
        for (RevizorroExpQuestion question : questions) {
            questionDTOList.add(new RevizorroExpQuestionDTO(question.getId(),question.getQuestion()));
        }
        return questionDTOList;
    }
}
