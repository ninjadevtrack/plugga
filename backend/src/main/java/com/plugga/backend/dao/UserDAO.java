package com.plugga.backend.dao;

import java.util.List;

import com.plugga.backend.entity.User;

public interface UserDAO {
    List<User> findAll();
    
    User findById(int id);
    
    void save(User user);
    
    void deleteById(int id);
}
