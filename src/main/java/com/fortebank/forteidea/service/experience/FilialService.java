package com.fortebank.forteidea.service.experience;

import com.fortebank.forteidea.entity.experience.Filial;
import com.fortebank.forteidea.repository.experience.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository;

    public List<Filial> getAllActiveFilials() {
        return filialRepository.findAllActiveFilials();
    }

    public Optional<Filial> getFilialById(Long id) {
        return filialRepository.findById(id);
    }
}
