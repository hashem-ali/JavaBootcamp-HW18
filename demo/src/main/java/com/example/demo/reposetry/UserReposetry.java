package com.example.demo.reposetry;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReposetry extends JpaRepository<User, Integer> {
//    User findUserByAge(int age);

    User findUserByEmail(String email);



    @Query("select u from User u where u.username=?1 and u.password=?2 ")
    User findUserByUsernameAndPassword(String username, String password);

    User findAllByRoleContains(String role);

    User findAllByAgeOrAgeAfter(Integer age);
}
