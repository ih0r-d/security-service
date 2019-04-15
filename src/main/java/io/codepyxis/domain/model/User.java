package io.codepyxis.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;
    @Column(name = "EMAIL",nullable = false)
    @Email
    private String email;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "ACTIVE",nullable = false)
    private boolean isActive;


}
