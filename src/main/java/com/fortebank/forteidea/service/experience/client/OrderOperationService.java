package com.fortebank.forteidea.service.experience.client;

import com.fortebank.forteidea.dto.CreateResponseDTO;
import com.fortebank.forteidea.dto.experience.client.OperationCreateRequest;
import com.fortebank.forteidea.entity.experience.client.OrderOperation;
import com.fortebank.forteidea.entity.experience.client.OrderType;
import com.fortebank.forteidea.repository.experience.client.OrderOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fortebank.forteidea.util.ResponseStatusConstant.*;

@Service
public class OrderOperationService {
    @Autowired
    private OrderOperationRepository orderOperationRepository;

    @Autowired
    private OrderTypeService orderTypeService;

    public List<OrderOperation> findByOrderType(OrderType orderType) {
        return orderOperationRepository.findAllByOrderType(orderType);
    }

    public Optional<OrderOperation> findById(Long id) {
        return orderOperationRepository.findById(id);
    }

    public CreateResponseDTO addOperation(OperationCreateRequest operation) {
        CreateResponseDTO responseDTO = new CreateResponseDTO();
        try {
            OrderOperation orderOperation = new OrderOperation();
            orderOperation.setName(operation.getName());
            Optional<OrderType> orderTypeOptional = orderTypeService.findById(operation.getType().toUpperCase());
            OrderType orderType = orderTypeOptional.isPresent() ? orderTypeOptional.get() : null;
            if (orderType != null){
                orderOperation.setOrderType(orderType);
                orderOperationRepository.save(orderOperation);
                responseDTO.setId(orderOperation.getId());
                responseDTO.setCode(SUCCESS_CODE);
                responseDTO.setMessage(SUCCESS_MESSAGE);
            } else {
                responseDTO.setCode(ORDER_TYPE_NOT_FOUND_EXCEPTION_CODE);
                responseDTO.setMessage(ORDER_TYPE_NOT_FOUND_EXCEPTION_MESSAGE);
            }
        } catch (Exception e){
            responseDTO.setCode(ADD_OPERATION_EXCEPTION_CODE);
            responseDTO.setMessage(e.getMessage());
        }

        return responseDTO;
    }
}
