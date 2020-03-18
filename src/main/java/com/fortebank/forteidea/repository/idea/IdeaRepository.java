package com.fortebank.forteidea.repository.idea;

import com.fortebank.forteidea.entity.idea.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea, Long> {

}
