package edu.userdemo.controller;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;
import edu.userdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
public class UserController {
    @Autowired
    private UserService userService;
    // Calling Service Layer to create a new user given from Postman.
    @PostMapping("create")
    public ResponseEntity<UserDTO> createUserController(@RequestBody UserDTO userdto) {
        UserDTO ud= userService.createUser(userdto);
        return new ResponseEntity<>(ud, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<UserDTO> findAllUsersController() {
        return userService.getAllUsers();
    }

    @GetMapping("all/{userid}")
    public UserDTO getUsersController(@PathVariable(name = "userid") Integer id) {
        return userService.getUserById(id);
    }
    @PutMapping("update/{id}")
    public UserDTO updateUserController(@PathVariable Integer id, @RequestBody UserDTO userdto) {
        return userService.updateUser(userdto, id);
    }
    @DeleteMapping("delete/{id}")
    public String  deleteUserController(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}

