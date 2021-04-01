package com.accure.api.restcontroller;

import com.accure.api.models.User;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/user")
public class UserRController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public User findUser(@PathVariable Long id) throws EntityNotFoundException {
        User u = userService.find(id);
        return u;
    }

    @PostMapping("add")
    public String insert(@RequestBody User u) {
        return userService.insert(u);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Long id) throws EntityNotFoundException {
        return userService.delete(id);
    }
}
