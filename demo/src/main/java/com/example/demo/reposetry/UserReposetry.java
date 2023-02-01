package com.example.demo.reposetry;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserReposetry extends JpaRepository<User, Integer> {
//    User findUserByAge(int age);
    User findUserById(Integer id);
    User findUserByEmail(String email);

    User findUserByUsernameAndPassword(String username, String password);

//    @Query("select u from User u where u.username=?1 and u.password=?2 ")
//    User findUserByUsernameAndPassword(String username, String password);

    List<User> findUsersByRole(String role);
//
    List<User> findUsersByAgeGreaterThanEqual(Integer age);
}
