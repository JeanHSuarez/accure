package com.accure.api.dao;

import com.accure.api.models.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TimeLogDAO extends JpaRepository<TimeLog, Long> {
}
