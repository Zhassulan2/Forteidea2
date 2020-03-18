package com.fortebank.forteidea.service.idea;

import com.fortebank.forteidea.entity.idea.Process;
import com.fortebank.forteidea.repository.idea.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ProcessService {
    @Autowired
    private final ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    public List<Process> getAllActiveProcesses(){
        return processRepository.findAllActiveProcesses();
    }

    public Optional<Process> findById(Long id){
        return processRepository.findById(id);
    }
}
