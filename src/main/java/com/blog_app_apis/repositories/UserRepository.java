package com.blog_app_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_app_apis.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
