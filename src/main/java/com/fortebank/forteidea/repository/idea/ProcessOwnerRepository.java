package com.fortebank.forteidea.repository.idea;

import com.fortebank.forteidea.entity.idea.ProcessOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProcessOwnerRepository extends JpaRepository<ProcessOwner, Long> {
    @Query(value = "select * from public.process_owners o where o.active=1", nativeQuery = true)
    public List<ProcessOwner> findAllActiveProcesses();

    @Query(value = "select * from public.process_owners o where o.active=true and o.process_id = ?1", nativeQuery = true)
    List<ProcessOwner> findAllByProcessId(@Param("processId") Long processId);

    @Query(value = "select * from public.process_owners o where o.active=true and o.id=?1 and o.process_id = ?2", nativeQuery = true)
    Optional<ProcessOwner> findByIdAndProcessId(@Param("id") Long id, @Param("processId") Long processId);
}
