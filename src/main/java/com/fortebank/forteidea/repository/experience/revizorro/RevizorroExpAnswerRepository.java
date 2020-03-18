package com.fortebank.forteidea.repository.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevizorroExpAnswerRepository extends JpaRepository<RevizorroExpAnswer, Long> {
    @Query(value = "select * from public.revizorro_experience_answers a\n" +
            "\tleft join public.revizorro_experience_questions q ON q.id = a.question_id\n" +
            "\twhere q.category_id=?1 and a.revizorro_experience_id=?2", nativeQuery = true)
    public List<RevizorroExpAnswer> findAllByCategoryIdAndExperienceId(Long categoryId, Long experienceId);
}
