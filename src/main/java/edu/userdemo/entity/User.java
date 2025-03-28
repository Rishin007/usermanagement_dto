package edu.userdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer id;
    @Column(name = "username",nullable = false,unique = true,length = 14)
    private String name;
    @Column(name = "useremail",nullable = false,unique = true,length = 20)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
