package com.fortebank.forteidea.service.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpAnswer;
import com.fortebank.forteidea.repository.experience.revizorro.RevizorroExpAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevizorroExpAnswerService {
    @Autowired
    private RevizorroExpAnswerRepository revizorroExpAnswerRepository;

    public List<RevizorroExpAnswer> findAllAnswers(){
        return revizorroExpAnswerRepository.findAll();
    }

    public List<RevizorroExpAnswer> findAllByCategoryAndExperience(Long categoryId, Long experienceId) {
        return revizorroExpAnswerRepository.findAllByCategoryIdAndExperienceId(categoryId, experienceId);
    }

    public void saveAnswer(RevizorroExpAnswer answer){
        revizorroExpAnswerRepository.save(answer);
    }
    public void saveAnswer(List<RevizorroExpAnswer> answers){
        revizorroExpAnswerRepository.saveAll(answers);
    }

    public Optional<RevizorroExpAnswer> findById(Long id){
        return revizorroExpAnswerRepository.findById(id);
    }
}
