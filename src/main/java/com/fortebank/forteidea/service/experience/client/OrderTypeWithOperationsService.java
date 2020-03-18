package com.fortebank.forteidea.service.experience.client;

import com.fortebank.forteidea.dto.experience.client.OrderOperationDTO;
import com.fortebank.forteidea.dto.experience.client.OrderTypeWithOperationsDTO;
import com.fortebank.forteidea.entity.experience.client.OrderOperation;
import com.fortebank.forteidea.entity.experience.client.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderTypeWithOperationsService {
    @Autowired
    OrderTypeService orderTypeService;

    @Autowired
    OrderOperationService orderOperationService;

    public List<OrderTypeWithOperationsDTO> findTypesWithOperations(){
        List<OrderTypeWithOperationsDTO> orderTypeWithOperationsDTOList = new ArrayList<>();
        List<OrderType> orderTypes = orderTypeService.findAll();
        for (OrderType orderType : orderTypes) {
            OrderTypeWithOperationsDTO orderTypeWithOperationsDTO = new OrderTypeWithOperationsDTO(orderType.getType(),
                    mapOrderOperationsToDTO(orderOperationService.findByOrderType(orderType)));
            orderTypeWithOperationsDTOList.add(orderTypeWithOperationsDTO);
        }
        return orderTypeWithOperationsDTOList;
    }

    private List<OrderOperationDTO> mapOrderOperationsToDTO(List<OrderOperation> orderOperations){
        List<OrderOperationDTO> orderOperationDTOList = new ArrayList<>();
        for (OrderOperation orderOperation : orderOperations) {
            orderOperationDTOList.add(new OrderOperationDTO(orderOperation.getId(), orderOperation.getName()));
        }
        return orderOperationDTOList;
    }
}
