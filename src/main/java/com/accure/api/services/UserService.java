package com.accure.api.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import com.accure.api.dao.UserDAO;
import com.accure.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

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
