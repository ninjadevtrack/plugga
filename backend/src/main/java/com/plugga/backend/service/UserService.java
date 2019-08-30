package com.plugga.backend.service;

import java.util.List;

import com.plugga.backend.entity.User;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);
}