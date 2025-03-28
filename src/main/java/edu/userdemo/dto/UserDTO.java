package edu.userdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// This is a DTO replicating User.class and object of this class will be travelling across multuiple layer of the project...
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
