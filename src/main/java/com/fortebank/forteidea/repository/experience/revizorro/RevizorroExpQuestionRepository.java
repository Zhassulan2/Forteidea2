package com.fortebank.forteidea.repository.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpCategory;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RevizorroExpQuestionRepository extends JpaRepository<RevizorroExpQuestion, Long> {
    List<RevizorroExpQuestion> findAllByCategory(RevizorroExpCategory category);
}
