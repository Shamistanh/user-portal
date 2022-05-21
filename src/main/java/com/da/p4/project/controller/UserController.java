package com.da.p4.project.controller;

import com.da.p4.project.dto.UserDto;
import com.da.p4.project.model.User;
import com.da.p4.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@Api(value = "User Portal Controller")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    @ApiOperation(value = "It is for fetching all users", nickname = "users", response = User.class)
    public List<User> getAllUsers() {
        log.info("All users are requested with /users GET request");
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "It is for fetching specific user", nickname = "user", response = User.class)
    public Optional<User> getUser(@PathVariable(value = "id") Long userId) {
        log.info("A user is requested with /user/id GET request");
        return userService.getUser(userId);
    }

    @PutMapping("/users/{id}")
    @ApiOperation(value = "It is for updating specific user", nickname = "update-user")
    public void updateUser(@PathVariable(value = "id") Long userId,
                             @Valid @RequestBody UserDto userDto) {
        log.info("A user will be updated with Put request");
         userService.updateUser(userDto, userId);
    }

    @PostMapping("/user")
    @ApiOperation(value = "It is for adding a new user", nickname = "add-user")
    public String addUser(@Valid @RequestBody UserDto userDto) {
        log.info("A new user will be added");
       return userService.addUser(userDto);
    }

    @DeleteMapping("/users")
    @ApiOperation(value = "It is for deleting all users", nickname = "delete-users")
    public String deleteAll() {
        log.info("A new user will be added");
        return userService.deleteAll();
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "It is for deleting specific user", nickname = "delete-user", response = User.class)
    public String deleteUser(@PathVariable(value = "id") Long userId) {
        log.info("A user is requested with /user/id GET request");
        return userService.deleteUser(userId);
    }



}
