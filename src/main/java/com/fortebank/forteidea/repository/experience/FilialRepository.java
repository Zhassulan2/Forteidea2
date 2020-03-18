package com.fortebank.forteidea.repository.experience;

import com.fortebank.forteidea.entity.experience.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilialRepository extends JpaRepository<Filial, Long> {
    @Query(value = "select * from public.filial f where f.active=true", nativeQuery = true)
    public List<Filial> findAllActiveFilials();
}
