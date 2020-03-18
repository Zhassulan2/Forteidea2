package com.fortebank.forteidea.service.experience.client;

import com.fortebank.forteidea.dto.ResponseDTO;
import com.fortebank.forteidea.dto.UserDTO;
import com.fortebank.forteidea.entity.*;
import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.entity.experience.Filial;
import com.fortebank.forteidea.entity.experience.client.OrderOperation;
import com.fortebank.forteidea.entity.experience.client.OrderType;
import com.fortebank.forteidea.exceptions.DataNotFilledException;
import com.fortebank.forteidea.exceptions.DataNotFoundException;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceBodyRequestDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceCreateResponseDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceDTO;
import com.fortebank.forteidea.dto.experience.client.ClientExperienceResponseDTO;
import com.fortebank.forteidea.entity.experience.client.ClientExperience;
import com.fortebank.forteidea.repository.experience.client.ClientExperienceRepository;
import com.fortebank.forteidea.service.*;
import com.fortebank.forteidea.service.experience.BranchService;
import com.fortebank.forteidea.service.experience.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fortebank.forteidea.util.ResponseStatusConstant.*;

@Service
public class ClientExperienceService {
    @Autowired
    private ClientExperienceRepository clientExperienceRepository;

    @Autowired
    private BranchService branchService;

    @Autowired
    private FilialService filialService;

    @Autowired
    private OrderOperationService orderOperationService;

    @Autowired
    private OrderTypeService orderTypeService;

    @Autowired
    private UserService userService;

    public ClientExperienceResponseDTO getAll() {
        ClientExperienceResponseDTO clientExperienceResponseDTO = new ClientExperienceResponseDTO();
        try {
            clientExperienceResponseDTO.setClientExperience(mapExperienceData(clientExperienceRepository.findAll()));
            clientExperienceResponseDTO.setCode(SUCCESS_CODE);
            clientExperienceResponseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (Exception e) {
            clientExperienceResponseDTO.setCode(CLIENT_EXP_DATA_EXCEPTION_CODE);
            clientExperienceResponseDTO.setMessage(e.getMessage());
        }
        return clientExperienceResponseDTO;
    }

    private List<ClientExperienceDTO> mapExperienceData(List<ClientExperience> clientExperienceList) {
        List<ClientExperienceDTO> clientExperienceDTOList = new ArrayList<>();
        for (ClientExperience clientExperience : clientExperienceList) {
            UserDTO initiator = new UserDTO();
            if (clientExperience.getInitiator() != null) {
                initiator = new UserDTO(clientExperience.getInitiator().getUsername(), clientExperience.getInitiator().getFullname());
            }
            ClientExperienceDTO clientExperienceDTO = new ClientExperienceDTO(clientExperience.getId(),
                    (clientExperience.getBranch() == null) ? null : clientExperience.getBranch().getId(),
                    (clientExperience.getFilial() == null) ? null : clientExperience.getFilial().getId(),
                    (clientExperience.getOrderType() == null) ? null : clientExperience.getOrderType().getType(),
                    (clientExperience.getOperation() == null) ? null : clientExperience.getOperation().getId(),
                    clientExperience.getExperience(), clientExperience.getProblem(), clientExperience.getInitDate(),
                    initiator);
            clientExperienceDTOList.add(clientExperienceDTO);
        }
        return clientExperienceDTOList;
    }

    public ClientExperienceCreateResponseDTO addExperience(ClientExperienceBodyRequestDTO clientExperienceRequestDTO) {
        ClientExperienceCreateResponseDTO experienceCreateResponseDTO = new ClientExperienceCreateResponseDTO();
        try {
            ClientExperience clientExperience = mapClientExpFromRequest(clientExperienceRequestDTO);
            clientExperienceRepository.save(clientExperience);
            experienceCreateResponseDTO.setClientExperienceId(clientExperience.getId());
            experienceCreateResponseDTO.setCode(SUCCESS_CODE);
            experienceCreateResponseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFilledException e) {
            experienceCreateResponseDTO.setCode(DATA_FILL_EXCEPTION_CODE);
            experienceCreateResponseDTO.setMessage(e.getMessage() + e.getField());
        } catch (DataNotFoundException e) {
            experienceCreateResponseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            experienceCreateResponseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            experienceCreateResponseDTO.setCode(CLIENT_EXP_CREATE_EXCEPTION_CODE);
            experienceCreateResponseDTO.setMessage(e.getMessage());
        }
        return experienceCreateResponseDTO;
    }

    public ResponseDTO updateExperience(Long id, ClientExperienceBodyRequestDTO clientExperienceRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            ClientExperience clientExperience = mapClientExpFromRequest(clientExperienceRequestDTO);
            clientExperience.setId(id);
            clientExperienceRepository.save(clientExperience);
            responseDTO.setCode(SUCCESS_CODE);
            responseDTO.setMessage(SUCCESS_MESSAGE);
        } catch (DataNotFilledException e) {
            responseDTO.setCode(DATA_FILL_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (DataNotFoundException e) {
            responseDTO.setCode(DATA_NOT_FOUND_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage() + e.getField());
        } catch (Exception e) {
            responseDTO.setCode(CLIENT_EXP_UPDATE_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    private ClientExperience mapClientExpFromRequest(ClientExperienceBodyRequestDTO clientExperienceRequestDTO) throws DataNotFilledException {
        ClientExperience clientExperience = new ClientExperience();

        if (clientExperienceRequestDTO.getBranch() != null) {
            Optional<Branch> branchOptional = branchService.findById(clientExperienceRequestDTO.getBranch());
            Branch branch = branchOptional.isPresent() ? branchOptional.get() : null;
            if (branch != null) {
                clientExperience.setBranch(branch);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "branch");
            }
        }

        if (clientExperienceRequestDTO.getFilial() != null) {
            Optional<Filial> filialOptional = filialService.getFilialById(clientExperienceRequestDTO.getFilial());
            Filial filial = filialOptional.isPresent() ? filialOptional.get() : null;
            if (filial != null) {
                clientExperience.setFilial(filial);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "filial");
            }
        }
        if (clientExperienceRequestDTO.getOrderType() != null) {
            Optional<OrderType> orderTypeOptional = orderTypeService.findById(clientExperienceRequestDTO.getOrderType());
            OrderType orderType = orderTypeOptional.isPresent() ? orderTypeOptional.get() : null;
            if (orderType != null) {
                clientExperience.setOrderType(orderType);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "orderType");
            }
        }

        if (clientExperienceRequestDTO.getOperation() != null) {
            Optional<OrderOperation> orderOperationOptional = orderOperationService.findById(clientExperienceRequestDTO.getOperation());
            OrderOperation orderOperation = orderOperationOptional.isPresent() ? orderOperationOptional.get() : null;
            if (orderOperation != null) {
                clientExperience.setOperation(orderOperation);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "orderOperation");
            }
        }


        clientExperience.setExperience(clientExperienceRequestDTO.getExperience());
        clientExperience.setProblem(clientExperienceRequestDTO.getProblem());
        if (clientExperienceRequestDTO.getInitDate() != null) {
            java.sql.Timestamp initDate = java.sql.Timestamp.valueOf(clientExperienceRequestDTO.getInitDate());
            clientExperience.setInitDate(initDate);
        }
        if (clientExperienceRequestDTO.getInitiator() != null) {
            if (userService.findAllByUsername(clientExperienceRequestDTO.getInitiator()).size() > 0) {
                User initiator = userService.findAllByUsername(clientExperienceRequestDTO.getInitiator()).get(0);
                clientExperience.setInitiator(initiator);
            } else {
                throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION_MESSAGE, "initiator");
            }

        } else {
            throw new DataNotFilledException(DATA_FILL_EXCEPTION_MESSAGE, "initiator");
        }
        return clientExperience;
    }
}
