package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hezhongchen on 2017/9/14.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName, String email);
}
