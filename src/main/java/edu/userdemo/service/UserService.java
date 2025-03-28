package edu.userdemo.service;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;
import java.util.List;

public interface UserService {

// This method is used to create a new user
        UserDTO createUser(UserDTO user);
//Get all users
        List<UserDTO> getAllUsers();
        // Get a particular user by ID
        UserDTO getUserById(Integer id);
        // Updating an user by DTO
        UserDTO updateUser(UserDTO userdto,Integer id);

        String deleteUser(Integer id);
    }

