package com.fortebank.forteidea.repository.idea;

import com.fortebank.forteidea.entity.idea.Idea;
import com.fortebank.forteidea.entity.idea.IdeaRates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeaRatesRepository extends JpaRepository<IdeaRates, Long> {
    public List<IdeaRates> findAllByIdea(Idea idea);
}
