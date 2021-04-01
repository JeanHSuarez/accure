package com.accure.api.services;

import com.accure.api.dao.TimeLogDAO;
import com.accure.api.models.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeLogService {


    @Autowired
    TimeLogDAO timeLogDAO;

    public TimeLog find(Long id) throws EntityNotFoundException {
        TimeLog t = null;
        Optional<TimeLog> opt = timeLogDAO.findById(id);

        if (opt.isPresent()){
            t = opt.get();
        }else {
            throw new EntityNotFoundException(id + " doesn't exist");
        }
        return t;
    }
    public  String insert(TimeLog t){
        Optional<TimeLog> opt = timeLogDAO.findById(t.getId());
        if (!opt.isPresent()) {
            timeLogDAO.save(t);
            return "success";
        }
        return t.getId() + " already exist";
    }

    public String delete(Long id) throws EntityNotFoundException{
        Optional<TimeLog> opt = timeLogDAO.findById(id);
        if (opt.isPresent()) {
            TimeLog t = opt.get();
            timeLogDAO.deleteById(id);
        } else {
            throw new EntityNotFoundException("Organization" + id + "doesn't exist");
        }
        return "success";
    }
}
