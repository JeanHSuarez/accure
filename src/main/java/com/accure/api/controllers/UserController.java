package com.accure.api.controllers;

import com.accure.api.models.TimeLog;
import com.accure.api.models.User;
import com.accure.api.services.EntityNotFoundException;
import com.accure.api.services.UserService;

import java.util.List;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping(path = "/user", produces = {APPLICATION_JSON_VALUE})
@Tag(name = "User API", description = "CRUD Operations for User")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("users")
    @Operation(summary = "Get the list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "4XX", description = "Client error"),
            @ApiResponse(responseCode = "5XX", description = "Server error")})
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUsers() throws EntityNotFoundException{
    	
    	List<User> users = userService.findAll();
    	return users;  	
    }
    
    @GetMapping("{id}/timelogs")
    @Operation(summary = "Get the list of all user timelogs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "4XX", description = "Client error"),
            @ApiResponse(responseCode = "5XX", description = "Server error")})
    @ResponseStatus(code = HttpStatus.OK)
    public List<TimeLog> findByTimeLogId(@PathVariable Long id) throws EntityNotFoundException {
    	User u = userService.find(id);
    	return u.getTimeLogList();
    }
    
    @GetMapping("{id}")
    @Operation(summary = "Find user using ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "4XX", description = "Client error"),
            @ApiResponse(responseCode = "5XX", description = "Server error")})
    @ResponseStatus(code = HttpStatus.OK)
    public User findUser(@PathVariable Long id) throws EntityNotFoundException {
        User u = userService.find(id);
        return u;
    }

    @PostMapping("add")
    @Operation(summary = "Add a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "4XX", description = "Client error"),
            @ApiResponse(responseCode = "5XX", description = "Server error")})
    @ResponseStatus(code = HttpStatus.OK)
    public String insert(@RequestBody User u) {
        return userService.insert(u);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "4XX", description = "Client error"),
            @ApiResponse(responseCode = "5XX", description = "Server error")})
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteById(@PathVariable Long id) throws EntityNotFoundException {
        return userService.delete(id);
    }
    
    
}
