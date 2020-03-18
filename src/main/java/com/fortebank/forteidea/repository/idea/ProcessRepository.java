package com.fortebank.forteidea.repository.idea;

import com.fortebank.forteidea.entity.idea.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    @Query(value = "select * from public.processes p where p.active=true", nativeQuery = true)
    public List<Process> findAllActiveProcesses();
}
