package com.plugga.backend.dao;

import com.plugga.backend.entity.Side;

import java.util.List;

public interface SideDAO {
    public List<Side> findAll();

    public Side findById(int id);

    public void save(Side side);

    public void deleteById(int id);
}
