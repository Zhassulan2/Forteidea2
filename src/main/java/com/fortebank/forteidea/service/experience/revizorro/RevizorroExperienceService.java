package com.fortebank.forteidea.service.experience.revizorro;

import com.fortebank.forteidea.dto.CreateResponseDTO;
import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.dto.UserDTO;
import com.fortebank.forteidea.dto.experience.revizorro.*;
import com.fortebank.forteidea.entity.User;
import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.entity.experience.Filial;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpAnswer;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpCategory;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExpQuestion;
import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExperience;
import com.fortebank.forteidea.exceptions.DataNotFilledException;
import com.fortebank.forteidea.exceptions.DataNotFoundException;
import com.fortebank.forteidea.repository.experience.revizorro.RevizorroExperienceRepository;
import com.fortebank.forteidea.service.UserService;
import com.fortebank.forteidea.service.experience.BranchService;
import com.fortebank.forteidea.service.experience.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fortebank.forteidea.util.ResponseStatusConstant.*;

@Service
public class RevizorroExperienceService {
    @Autowired
    private RevizorroExperienceRepository revizorroExperienceRepository;

    @Autowired
    private RECategoryService categoryService;

    @Autowired
    private RevizorroExpAnswerService revizorroExpAnswerService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private FilialService filialService;

    @Autowired
    private UserService userService;

    @Autowired
    private REQuestionService questionService;

    public List<RevizorroExperience> findAll() {
        return revizorroExperienceRepository.findAllActive();
    }

    public List<RevizorroExpDTO> findRevirorroExpDTO() {
        List<RevizorroExpDTO> revizorroExpDTOList = new ArrayList<>();
        List<RevizorroExperience> revizorroExperienceList = findAll();
        for (RevizorroExperience revizorroExperience : revizorroExperienceList) {
            List<RevizorroExpCategory> categories = categoryService.findAllCategories();
            List<CategoryWithAnswersDTO> categoryWithAnswersDTOList = new ArrayList<>();
            for (RevizorroExpCategory category : categories) {
                List<RevizorroExpAnswer> answers = revizorroExpAnswerService.findAllByCategoryAndExperience(category.getId(), revizorroExperience.getId());
                List<AnswerDTO> answerDTOList = mapCategoriesWithAnswersToDTO(answers);
                CategoryWithAnswersDTO categoryWithAnswersDTO = new CategoryWithAnswersDTO(category.getId(), category.getName(), answerDTOList);
                categoryWithAnswersDTOList.add(categoryWithAnswersDTO);
            }
            categoryWithAnswersDTOList = categoryWithAnswersDTOList.stream().filter(e -> !e.getAnswers().isEmpty()).collect(Collectors.toList());
            UserDTO initiatorDTO = new UserDTO(revizorroExperience.getInitiator().getUsername(), revizorroExperience.getInitiator().getFullname());
            RevizorroExpDTO revizorroExpDTO = new RevizorroExpDTO(revizorroExperience.getId(), revizorroExperience.getBranch().getId(),
                    revizorroExperience.getFilial().getId(), revizorroExperience.getInitDate(), initiatorDTO, categoryWithAnswersDTOList);
            revizorroExpDTOList.add(revizorroExpDTO);
        }
        return revizorroExpDTOList;
    }

    private List<AnswerDTO> mapCategoriesWithAnswersToDTO(List<RevizorroExpAnswer> answers) {
        List<AnswerDTO> answerDTOList = new ArrayList<>();
        for (RevizorroExpAnswer answer : answers) {
            AnswerDTO answerDTO = new AnswerDTO(answer.getId(), answer.getQuestion().getId(), answer.getAnswer());
            answerDTOList.add(answerDTO);
        }
        return answerDTOList;
    }

    public RevizorroExperienceResponseDTO getRevizorroExp() {
        RevizorroExperienceResponseDTO revizorroExperienceResponseDTO = new RevizorroExperienceResponseDTO();
        try {
            revizorroExperienceResponseDTO.setRevizorroExperience(findRevirorroExpDTO());
            revizorroExperienceResponseDTO.setCode(SUCCESS_CODE);
            revizorroExperienceResponseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (Exception e) {
            revizorroExperienceResponseDTO.setCode(REVIZ_EXP_DATA_EXCEPTION_CODE);
            revizorroExperienceResponseDTO.setMessage(e.getMessage());
        }
        return revizorroExperienceResponseDTO;
    }

    public ResponseDTO updateRevizorroExperience(Long id, REUpdateRequestDTO reCreateRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        RevizorroExperience revizorroExperience = null;
        try {
            revizorroExperience = mapREFromRequest(reCreateRequestDTO);
            revizorroExperience.setId(id);
            revizorroExperience.setActive(true);
            revizorroExperienceRepository.save(revizorroExperience);
            revizorroExpAnswerService.saveAnswer(mapAnswersForUpdate(reCreateRequestDTO.getAnswers()));
            responseDTO.setCode(SUCCESS_CODE);
            responseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFoundException e) {
            responseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            responseDTO.setCode(RE_UPDATE_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return responseDTO;
    }

    public CreateResponseDTO addRevizorroExperience(RECreateRequestDTO reCreateRequestDTO) {
        CreateResponseDTO responseDTO = new CreateResponseDTO();
        RevizorroExperience revizorroExperience = null;
        try {
            revizorroExperience = mapREFromRequest(reCreateRequestDTO);
            revizorroExperienceRepository.save(revizorroExperience);
            revizorroExpAnswerService.saveAnswer(mapNewAnswers(reCreateRequestDTO.getAnswers(), revizorroExperience));
            revizorroExperienceRepository.setActive(revizorroExperience.getId());

            responseDTO.setId(revizorroExperience.getId());
            responseDTO.setCode(SUCCESS_CODE);
            responseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFoundException e) {
            responseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            responseDTO.setCode(RE_CREATE_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    private RevizorroExperience mapREFromRequest(REBodyRequestDTO reBodyRequestDTO) throws DataNotFilledException {
        RevizorroExperience revizorroExperience = new RevizorroExperience();
        if (reBodyRequestDTO.getBranch() != null) {
            Optional<Branch> branchOptional = branchService.findById(reBodyRequestDTO.getBranch());
            Branch branch = branchOptional.isPresent() ? branchOptional.get() : null;
            if (branch != null) {
                revizorroExperience.setBranch(branch);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "branch");
            }
        }

        if (reBodyRequestDTO.getFilial() != null) {
            Optional<Filial> filialOptional = filialService.getFilialById(reBodyRequestDTO.getFilial());
            Filial filial = filialOptional.isPresent() ? filialOptional.get() : null;
            if (filial != null) {
                revizorroExperience.setFilial(filial);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "filial");
            }
        }

        if (reBodyRequestDTO.getInitDate() != null) {
            java.sql.Timestamp initDate = java.sql.Timestamp.valueOf(reBodyRequestDTO.getInitDate());
            revizorroExperience.setInitDate(initDate);
        }
        if (reBodyRequestDTO.getInitiator() != null) {
            if (userService.findAllByUsername(reBodyRequestDTO.getInitiator()).size() > 0) {
                User initiator = userService.findAllByUsername(reBodyRequestDTO.getInitiator()).get(0);
                revizorroExperience.setInitiator(initiator);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "initiator");
            }

        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "initiator");
        }
        return revizorroExperience;
    }

    private List<RevizorroExpAnswer> mapNewAnswers(List<RECreateAnswerDTO> answerDTOList, RevizorroExperience revizorroExperience) {
        List<RevizorroExpAnswer> answers = new ArrayList<>();
        for (RECreateAnswerDTO answerDTO : answerDTOList) {
            RevizorroExpAnswer answer = new RevizorroExpAnswer();
            answer.setRevizorroExperience(revizorroExperience);
            Optional<RevizorroExpQuestion> questionOptional = questionService.findById(answerDTO.getQuestionId());
            RevizorroExpQuestion question = questionOptional.isPresent() ? questionOptional.get() : null;
            if (question != null) {
                answer.setQuestion(question);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "questionId " + answerDTO.getQuestionId());
            }
            answer.setAnswer(answerDTO.getAnswer());
            answers.add(answer);
        }
        return answers;
    }

    private List<RevizorroExpAnswer> mapAnswersForUpdate(List<REUpdateAnswerDTO> answerDTOList) {
        List<RevizorroExpAnswer> answers = new ArrayList<>();
        for (REUpdateAnswerDTO answerDTO : answerDTOList) {
            Optional<RevizorroExpAnswer> answerOptional = revizorroExpAnswerService.findById(answerDTO.getAnswerId());
            RevizorroExpAnswer answer = answerOptional.isPresent() ? answerOptional.get() : null;
            if(answer != null){
                answer.setAnswer(answerDTO.getAnswer());
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "answerId " + answerDTO.getAnswerId());
            }
            answers.add(answer);
        }
        return answers;
    }
}
