package com.fortebank.forteidea.dto.experience.client;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class OrderTypeWithOperationsDTO {
    private String orderType;
    private List<OrderOperationDTO> operations;

    public OrderTypeWithOperationsDTO() {
    }

    public OrderTypeWithOperationsDTO(String orderType, List<OrderOperationDTO> operations) {
        this.orderType = orderType;
        this.operations = operations;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<OrderOperationDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OrderOperationDTO> operations) {
        this.operations = operations;
    }
}
