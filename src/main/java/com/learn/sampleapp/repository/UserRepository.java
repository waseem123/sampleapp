package com.learn.sampleapp.repository;

import com.learn.sampleapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.user_email=:user_email AND u.user_password=:user_password")
    public User findByEmail(@Param("user_email") String username, @Param("user_password") String user_password);
}
