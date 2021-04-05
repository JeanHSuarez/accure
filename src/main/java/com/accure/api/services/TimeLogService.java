package com.accure.api.services;

import com.accure.api.dao.TimeLogDAO;
import com.accure.api.dao.UserDAO;
import com.accure.api.models.TimeLog;
import com.accure.api.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class TimeLogService {


    @Autowired
    TimeLogDAO timeLogDAO;
    
    @Autowired
    UserDAO userDAO;
    
    public List<TimeLog> findByTimeLogId(Long id) throws EntityNotFoundException {

    	User u = null;
    	List<TimeLog> timelogs;
    	Optional<User> user = userDAO.findById(id);
 	
    	if (user.isPresent()) {
    		u = user.get();
    		timelogs = u.getTimeLogList();
    		
    	} else {
    		throw new EntityNotFoundException(id + " doesn't exist");
    	}
    	
    	return timelogs;
    
    }
    
    public List<TimeLog> findAll() throws EntityNotFoundException {
    	List <TimeLog> t = timeLogDAO.findAll();
    	return t;
    }

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
