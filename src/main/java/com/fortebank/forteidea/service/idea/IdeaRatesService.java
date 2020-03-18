package com.fortebank.forteidea.service.idea;

import com.fortebank.forteidea.dto.idea.IdeaRateActionDTO;
import com.fortebank.forteidea.dto.idea.IdeaRatesActionEnum;
import com.fortebank.forteidea.entity.idea.Idea;
import com.fortebank.forteidea.entity.idea.IdeaRates;
import com.fortebank.forteidea.repository.idea.IdeaRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class IdeaRatesService {
    @Autowired
    private final IdeaRatesRepository ideaRatesRepository;

    public IdeaRatesService(IdeaRatesRepository ideaRatesRepository) {
        this.ideaRatesRepository = ideaRatesRepository;
    }

    public int findLikeAmountByIdea(Idea idea){
        List<IdeaRates> ideaRates = ideaRatesRepository.findAllByIdea(idea);
        return (int) ideaRates.stream().filter(ideaRates1 -> ideaRates1.getAction().equals(IdeaRatesActionEnum.LIKE)).count();
    }

    public int findDislikeAmountByIdea(Idea idea){
        List<IdeaRates> ideaRates = ideaRatesRepository.findAllByIdea(idea);
        return (int) ideaRates.stream().filter(ideaRates1 -> ideaRates1.getAction().equals(IdeaRatesActionEnum.DISLIKE)).count();
    }

    public IdeaRateActionDTO findLikeAndDislikeAmountByIdea(Idea idea){
        List<IdeaRates> ideaRates = ideaRatesRepository.findAllByIdea(idea);
        IdeaRateActionDTO ideaRateActionDTO = new IdeaRateActionDTO();
        ideaRateActionDTO.setLikeAmount((int) ideaRates.stream().filter(ideaRates1 -> ideaRates1.getAction().equals(IdeaRatesActionEnum.LIKE.getAction())).count());
        ideaRateActionDTO.setDislikeAmount((int) ideaRates.stream().filter(ideaRates1 -> ideaRates1.getAction().equals(IdeaRatesActionEnum.DISLIKE.getAction())).count());
        return ideaRateActionDTO;
    }
}
