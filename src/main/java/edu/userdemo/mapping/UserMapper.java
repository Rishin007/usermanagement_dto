package edu.userdemo.mapping;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;

public class UserMapper {
    public static UserDTO userToUserDTO(User user) {
        UserDTO userdto = new UserDTO();
        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setEmail(user.getEmail());
        return userdto;
    }

    public static User userDTOToUser(UserDTO userdto) {
        User user = new User();
        user.setId(userdto.getId());
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        return user;
    }
}
