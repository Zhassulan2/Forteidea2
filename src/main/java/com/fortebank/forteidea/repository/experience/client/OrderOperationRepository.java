package com.fortebank.forteidea.repository.experience.client;

import com.fortebank.forteidea.entity.experience.client.OrderOperation;
import com.fortebank.forteidea.entity.experience.client.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderOperationRepository extends JpaRepository<OrderOperation, Long> {
    List<OrderOperation> findAllByOrderType(OrderType type);
}
