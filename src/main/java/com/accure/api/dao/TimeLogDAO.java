package com.accure.api.dao;

import com.accure.api.models.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeLogDAO extends JpaRepository<TimeLog, Long> {
}
