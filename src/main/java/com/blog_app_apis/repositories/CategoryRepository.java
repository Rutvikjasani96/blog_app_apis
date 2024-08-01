package com.blog_app_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_app_apis.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
