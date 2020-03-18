package com.fortebank.forteidea.repository.experience.revizorro;

import com.fortebank.forteidea.entity.experience.revizorro.RevizorroExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevizorroExperienceRepository extends JpaRepository<RevizorroExperience,Long> {
    @Query(value = "SELECT * FROM public.revizorro_experience e where e.active='true'", nativeQuery = true)
    List<RevizorroExperience> findAllActive();

    @Query(value = "UPDATE public.revizorro_experience set active='true' where id=?1 RETURNING id", nativeQuery = true)
    Long setActive(Long id);
}
