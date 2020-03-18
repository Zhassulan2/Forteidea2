package com.fortebank.forteidea.service.idea;

import com.fortebank.forteidea.dto.idea.IdeaBodyRequestDTO;
import com.fortebank.forteidea.dto.CreateResponseDTO;
import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.entity.idea.Idea;
import com.fortebank.forteidea.entity.idea.Process;
import com.fortebank.forteidea.entity.idea.ProcessOwner;
import com.fortebank.forteidea.entity.User;
import com.fortebank.forteidea.exceptions.DataNotFilledException;
import com.fortebank.forteidea.exceptions.DataNotFoundException;
import com.fortebank.forteidea.repository.idea.IdeaRepository;
import com.fortebank.forteidea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fortebank.forteidea.util.ResponseStatusConstant.*;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IdeaService {
    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProcessOwnerService processOwnerService;

    @Autowired
    private ProcessService processService;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public CreateResponseDTO addIdea(IdeaBodyRequestDTO ideaBodyRequestDTO) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        Idea idea = null;
        try {
            idea = fillIdeaData(ideaBodyRequestDTO);
            ideaRepository.save(idea);
            createResponseDTO.setId(idea.getId());
            createResponseDTO.setCode(SUCCESS_CODE);
            createResponseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFilledException e) {
            createResponseDTO.setCode(DATA_FILL_EXCEPTION_CODE);
            createResponseDTO.setMessage(e.getMessage() + e.getField());
        } catch (DataNotFoundException e) {
            createResponseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            createResponseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            createResponseDTO.setCode(CREATE_IDEA_EXCEPTION_CODE);
            createResponseDTO.setMessage(e.getMessage());
        }
        return createResponseDTO;
    }

    public ResponseDTO updateIdea(Long id, IdeaBodyRequestDTO ideaBodyRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Idea idea = fillIdeaData(ideaBodyRequestDTO);
            idea.setId(id);
            ideaRepository.save(idea);
            responseDTO.setCode(SUCCESS_CODE);
            responseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFilledException e) {
            responseDTO.setCode(DATA_FILL_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (DataNotFoundException e) {
            responseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            responseDTO.setCode(UPDATE_IDEA_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    private Idea fillIdeaData(IdeaBodyRequestDTO ideaBodyRequestDTO) throws DataNotFilledException, DataNotFoundException {
        Idea idea = new Idea();
        if (ideaBodyRequestDTO.getTitle() != null) {
            idea.setTitle(ideaBodyRequestDTO.getTitle());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "title");
        }
        if (ideaBodyRequestDTO.getInitiator() != null) {
            if (userService.findAllByUsername(ideaBodyRequestDTO.getInitiator()).size() > 0) {
                User initiator = userService.findAllByUsername(ideaBodyRequestDTO.getInitiator()).get(0);
                idea.setInitiator(initiator);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "initiator");
            }

        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "initiator");
        }
        if (ideaBodyRequestDTO.getPublicationDate() != null) {
            java.sql.Timestamp publicationDate = java.sql.Timestamp.valueOf(ideaBodyRequestDTO.getPublicationDate());
            idea.setPublicationDate(publicationDate);
        }
        if (ideaBodyRequestDTO.getDeadLine() != null) {
            java.sql.Timestamp deadLine = java.sql.Timestamp.valueOf(ideaBodyRequestDTO.getDeadLine());
            idea.setDeadLine(deadLine);
        }

        if (ideaBodyRequestDTO.getProcess() != null) {
            Optional<Process> processOptional = processService.findById(ideaBodyRequestDTO.getProcess());
            Process process = processOptional.isPresent() ? processOptional.get() : null;
            if (process != null) {
                idea.setProcess(process);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "process");
            }
        }
        if (ideaBodyRequestDTO.getLeanManager() != null) {
            Optional<ProcessOwner> leanManagesOptional = processOwnerService.findByIdAndProcessId(ideaBodyRequestDTO.getLeanManager(),
                    ideaBodyRequestDTO.getProcess());
            ProcessOwner leanManager = leanManagesOptional.isPresent() ? leanManagesOptional.get() : null;
            if (leanManager != null) {
                idea.setLeanManager(leanManager);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "leanManager");
            }
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "leanManager");
        }
        if (ideaBodyRequestDTO.getResponsible() != null) {
            Optional<ProcessOwner> leanManagesOptional = processOwnerService.findByIdAndProcessId(ideaBodyRequestDTO.getResponsible(),
                    ideaBodyRequestDTO.getProcess());
            ProcessOwner responsible = leanManagesOptional.isPresent() ? leanManagesOptional.get() : null;
            if(responsible != null){
                idea.setResponsible(responsible);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "responsible");
            }
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "responsible");
        }
        if (ideaBodyRequestDTO.getSavedHours() != 0) {
            idea.setSavedHours(ideaBodyRequestDTO.getSavedHours());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "savedHours");
        }
        if (ideaBodyRequestDTO.getSavedMoney() != 0) {
            idea.setSavedMoney(ideaBodyRequestDTO.getSavedMoney());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "savedMoney");
        }
        if (ideaBodyRequestDTO.getState() != null) {
            idea.setState(ideaBodyRequestDTO.getState());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "state");
        }
        if (ideaBodyRequestDTO.getAimedResult() != null) {
            idea.setAchievedResult(ideaBodyRequestDTO.getAimedResult());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "aimedResult");
        }
        if (ideaBodyRequestDTO.getExpectedResult() != null) {
            idea.setExpectedResult(ideaBodyRequestDTO.getExpectedResult());
        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "expectedResult");
        }
        return idea;
    }
}
