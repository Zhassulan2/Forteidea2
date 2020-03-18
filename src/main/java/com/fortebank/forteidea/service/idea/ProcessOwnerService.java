package com.fortebank.forteidea.service.idea;

import com.fortebank.forteidea.entity.idea.ProcessOwner;
import com.fortebank.forteidea.repository.idea.ProcessOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ProcessOwnerService {
    @Autowired
    private final ProcessOwnerRepository processOwnerRepository;

    public ProcessOwnerService(ProcessOwnerRepository processOwnerRepository) {
        this.processOwnerRepository = processOwnerRepository;
    }

    public List<ProcessOwner> findAllByProcessId(Long processId){
        return processOwnerRepository.findAllByProcessId(processId);
    }

    public Optional<ProcessOwner> findById(Long id){
        return processOwnerRepository.findById(id);
    }

    public Optional<ProcessOwner> findByIdAndProcessId(Long id, Long processId){
        return processOwnerRepository.findByIdAndProcessId(id, processId);
    }
}
