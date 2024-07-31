package com.blog_app_apis.services;

import java.util.List;

import com.blog_app_apis.payloads.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,int userId);
    UserDto getUserById(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(int userId);
}
