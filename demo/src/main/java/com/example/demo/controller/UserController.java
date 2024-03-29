package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("add")
    public ResponseEntity addUser( @RequestBody @Valid User user){
        userService.addUser( user);
        return ResponseEntity.status(200).body("Added Successfully");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUSer(@PathVariable Integer id, @Valid @RequestBody  User user){

         userService.updateUser(id, user);

            return ResponseEntity.status(200).body("Updated Successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Deleted Successfully");
        }
        return ResponseEntity.status(404).body("id Not Found");
    }

    ///////New End-Points
    @GetMapping("findByUsernameAndPassword/{username}/{password}")
    public ResponseEntity getByUsernameAndPassword(@PathVariable String username, @PathVariable String password){
     return ResponseEntity.status(200).body(userService.findUserByUsernameAndPassword(username, password));
    }
//
    @GetMapping("findByRole/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.findAllUsersByRole(role));
    }
//
    @GetMapping("findByAge/{age}")
    public ResponseEntity getByAge(@PathVariable int age){
        return ResponseEntity.status(200).body(userService.findAllUsersByAgeOrAbove(age));
    }
//
    @GetMapping("findByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.findUserByEmail(email));
    }

}
