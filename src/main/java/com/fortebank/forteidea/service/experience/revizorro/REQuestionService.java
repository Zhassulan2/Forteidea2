package com.fortebank.forteidea.service.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpCategory;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpQuestion;
import com.fortebank.forteidea.repository.experience.revizorro.RevizorroExpQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class REQuestionService {
    @Autowired
    RevizorroExpQuestionRepository revizorroExpQuestionRepository;

    public List<RevizorroExpQuestion> findQuestionsByCategory(RevizorroExpCategory category){
        return revizorroExpQuestionRepository.findAllByCategory(category);
    }

    public Optional<RevizorroExpQuestion> findById(Long id){
        return revizorroExpQuestionRepository.findById(id);
    }
}
