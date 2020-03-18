package com.fortebank.forteidea.service.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpCategory;
import com.fortebank.forteidea.repository.experience.revizorro.RevizorroExpCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RECategoryService {
    @Autowired
    private RevizorroExpCategoryRepository revizorroExpCategoryRepository;

    public List<RevizorroExpCategory> findAllCategories(){
        return revizorroExpCategoryRepository.findAll();
    }
}
