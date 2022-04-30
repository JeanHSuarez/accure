package com.accure.api.controllers;

import com.accure.api.models.TimeLog;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.TimeLogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/timelog")
public class TimeLogController {

    @Autowired
    TimeLogService timeLogService;
    
    @GetMapping("timelogs")
    public List<TimeLog> getTimeLogs() throws EntityNotFoundException {
    	List<TimeLog> timelogs = timeLogService.findAll();
    	return timelogs;
    }

    @GetMapping("{id}")
    public TimeLog findTimeLog(@PathVariable Long id) throws EntityNotFoundException{
        TimeLog t = timeLogService.find(id);
        return t;
    }
    
    @PostMapping("add")
    public String insert(@RequestBody TimeLog t) {
        return timeLogService.insert(t);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Long id) throws EntityNotFoundException{
        return timeLogService.delete(id);
    }
}