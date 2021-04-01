package com.accure.api.restcontroller;

import com.accure.api.models.TimeLog;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.TimeLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/timelog")
public class TimeLogRController {

    @Autowired
    TimeLogService timeLogService;

    @GetMapping("{id}")
    public TimeLog findTimeLog(@PathVariable Long id) throws  EntityNotFoundException{
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