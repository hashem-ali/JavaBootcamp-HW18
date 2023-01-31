package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name = "user_db")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotNull(message = "id must not be null")
    private Integer id;
    @Size(min = 4, message = "length must be more than 4")
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotNull(message = "username must not be null")
    @Size(min = 4, message = "username must be more than 4")
    @Column(unique = true)
    private String username;
    @NotNull(message = "password must not be null")
    private String password;
    @NotNull(message = "email must not be null")
    @Email(message = "Must be email")
    @Column(unique = true)
    private String email;
    @NotNull(message = "role must not be null")
    @Pattern(regexp = "(?:^|\\W)user(?:$|\\W)|(?:^|\\W)admin(?:$|\\W)", message = "role must be ")
    private String role;
    @NotNull(message = "age can't be null")
    @Positive(message = "must be int")
    private Integer age;


}
