package com.fortebank.forteidea.service;

import com.fortebank.forteidea.dto.idea.IdeaDTO;
import com.fortebank.forteidea.dto.idea.IdeaRateActionDTO;
import com.fortebank.forteidea.dto.MainPageResponseDTO;
import com.fortebank.forteidea.dto.UserDTO;
import com.fortebank.forteidea.entity.idea.Idea;
import com.fortebank.forteidea.service.idea.IdeaRatesService;
import com.fortebank.forteidea.service.idea.IdeaService;
import com.fortebank.forteidea.service.idea.ProcessWithOwnerService;
import com.fortebank.forteidea.util.ResponseStatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class MainPageDataService {
    @Autowired
    private MainPageResponseDTO mainPageResponseDTO;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private IdeaService ideaService;

    @Autowired
    private ProcessWithOwnerService processWithOwnerService;

    @Autowired
    private IdeaRatesService ideaRatesService;

    public MainPageResponseDTO getData() {
        try {
            mainPageResponseDTO.setVisitCounts(sessionService.countAllSessions());
            mainPageResponseDTO.setIdeas(mapIdeasData());
            mainPageResponseDTO.setProcesses(processWithOwnerService.getProcessesWithOwners());
            mainPageResponseDTO.setCode(ResponseStatusConstant.SUCCESS_CODE);
            mainPageResponseDTO.setMessage(ResponseStatusConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            mainPageResponseDTO.setCode(ResponseStatusConstant.LOAD_MAIN_PAGE_ERROR_CODE);
            mainPageResponseDTO.setMessage(e.getMessage());
        }
        return mainPageResponseDTO;
    }

    private List<IdeaDTO> mapIdeasData() throws Exception{
        List<IdeaDTO> ideaDTOList = new ArrayList<>();
        for (Idea idea : ideaService.getAllIdeas()) {
            UserDTO initiator = new UserDTO(idea.getInitiator().getUsername(), idea.getInitiator().getFullname());
            UserDTO leanManager = new UserDTO();
            if (idea.getLeanManager() != null) {
                leanManager.setUsername(idea.getLeanManager().getUser().getUsername());
                leanManager.setFullname(idea.getLeanManager().getUser().getFullname());
            }
            UserDTO responsible = new UserDTO();
            if(idea.getResponsible() != null){
                responsible.setUsername(idea.getResponsible().getUser().getUsername());
                responsible.setFullname(idea.getResponsible().getUser().getFullname());
            }
            IdeaDTO ideaDTO = new IdeaDTO(idea.getId(),idea.getTitle(),initiator,leanManager,responsible,(idea.getProcess() == null) ? null : idea.getProcess().getId(),idea.getPublicationDate(),
                    idea.getSavedHours(), idea.getSavedMoney(), idea.getState(),idea.getBody(),idea.getAchievedResult(),idea.getExpectedResult(),idea.getDeadLine());
            System.out.println(idea.getId());
            IdeaRateActionDTO ideaRateActionDTO = ideaRatesService.findLikeAndDislikeAmountByIdea(idea);
            System.out.println(ideaRateActionDTO.getDislikeAmount());
            System.out.println(ideaRateActionDTO.getLikeAmount());
            ideaDTO.setLikeAmount(ideaRateActionDTO.getLikeAmount());
            ideaDTO.setDislikeAmount(ideaRateActionDTO.getDislikeAmount());
            ideaDTOList.add(ideaDTO);
        }
        return ideaDTOList;
    }

}
