package com.plugga.backend.dao;

import java.util.List;

import com.plugga.backend.entity.User;

public interface UserDAO {
    public List<User> findAll();
    
    public User findById(int id);
    
    public void save(User user);
    
    public void deleteById(int id);
}
