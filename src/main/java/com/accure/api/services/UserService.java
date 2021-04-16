package com.accure.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.accure.api.dao.OrganizationDAO;
import com.accure.api.dao.UserDAO;
import com.accure.api.models.Organization;
import com.accure.api.models.TimeLog;
import com.accure.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    
    @Autowired
    OrganizationDAO organizationDAO;
    public List <User> findAll() throws EntityNotFoundException {
    	List<User> users = userDAO.findAll();
    	return users;
    }
    
    public List<User> findByOrgId(Long orgId) throws EntityNotFoundException {
    	Organization o = null;
    	List<User> users;
    	Optional<Organization> org = organizationDAO.findById(orgId);

    	if (org.isPresent()) {
    		o = org.get();
    		users = o.getUserList();
    	} else {
            throw new EntityNotFoundException(orgId + " doesn't exist");
        }
    	return users;
    }

    public User find(Long id) throws EntityNotFoundException {
        User u = null;
        Optional<User> opt = userDAO.findById(id);
        if (opt.isPresent()) {
            u = opt.get();
        } else {
            throw new EntityNotFoundException(id + " doesn't exist");
        }
        return u;
    }

    public String insert(User u) {
        Optional<User> opt = userDAO.findById(u.getId());

        if (!opt.isPresent()) {
            userDAO.save(u);
            return "success";
        }
        return u.getId() + " already exist";
    }

    public String delete(Long id) throws EntityNotFoundException {

        Optional<User> opt = userDAO.findById(id);

        if (opt.isPresent()) {
            User u = opt.get();
            userDAO.deleteById(id);
        }else {
            throw new EntityNotFoundException("User " + id + " doesn't exist");
        }
        return "success";
    }

}
