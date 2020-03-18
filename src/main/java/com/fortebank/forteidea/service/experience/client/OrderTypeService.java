package com.fortebank.forteidea.service.experience.client;

import com.fortebank.forteidea.entity.experience.client.OrderType;
import com.fortebank.forteidea.repository.experience.client.OrderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderTypeService {
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public List<OrderType> findAll(){
        return orderTypeRepository.findAll();
    }

    public Optional<OrderType> findById(String type){
        return orderTypeRepository.findById(type);
    }


}
