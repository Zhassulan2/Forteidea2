package com.fortebank.forteidea.repository.experience;

import com.fortebank.forteidea.entity.experience.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = "select * from public.branch b where b.active=true", nativeQuery = true)
    public List<Branch> findAllActiveBranches();
}
