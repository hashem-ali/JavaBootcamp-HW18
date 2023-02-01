package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.User;
import com.example.demo.reposetry.UserReposetry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposetry userReposetry;

    public List<User> getUser(){
        return userReposetry.findAll();
    }

    public void addUser( User user){
        userReposetry.save(user);
    }

    public void updateUser(Integer id, User user){
        User oldUser = userReposetry.findUserById(id);
        if(oldUser == null){
            throw new ApiException("User not found!");
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        userReposetry.save(oldUser);


    }

    public boolean deleteUser(int id){
        User oldUser = userReposetry.getById(id);
        if (oldUser == null){
            return false;
        }
        userReposetry.delete(oldUser);
        return true;

    }

    public User findUserByUsernameAndPassword(String username, String password){
        User user =  userReposetry.findUserByUsernameAndPassword(username, password);
        if(user == null){
            throw new ApiException("Username and Password not found");
        }
        return user;
    }
//
    public User findUserByEmail(String email){
        User user = userReposetry.findUserByEmail(email);
        if(user == null){
            throw new ApiException("Email not found");
        }
        return user;
    }
//
    public List<User> findAllUsersByRole(String role){
         List<User> users =  (List<User>) userReposetry.findUsersByRole(role);
        if(users == null){
            throw new ApiException("Role not found");
        }
        return users;
    }
//
    public List<User> findAllUsersByAgeOrAbove(int age){
        List<User> users = (List<User>) userReposetry.findUsersByAgeGreaterThanEqual(age);
        if(users == null){
            throw new ApiException("Age not found");
        }
        return users;
    }

//    public User findUserByAge(int age){
//        return userReposetry.findUserByAge(age);
//    }
//    public User findUserById(int id){
//        return userReposetry.findUserIdForMe(id);
//    }
}
