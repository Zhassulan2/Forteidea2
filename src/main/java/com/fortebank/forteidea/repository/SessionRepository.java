package com.fortebank.forteidea.repository;

import com.fortebank.forteidea.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query(value = "select count(*) from public.session s", nativeQuery = true)
    int countAllSessions();
}
