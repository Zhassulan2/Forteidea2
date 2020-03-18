package com.fortebank.forteidea.service.experience;

import com.fortebank.forteidea.entity.experience.Branch;
import com.fortebank.forteidea.repository.experience.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllActiveBranches(){
        return branchRepository.findAllActiveBranches();
    }

    public Optional<Branch> findById(Long id){
        return branchRepository.findById(id);
    }
}
