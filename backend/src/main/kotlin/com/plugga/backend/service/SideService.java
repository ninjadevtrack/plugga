package com.plugga.backend.service;

import com.plugga.backend.entity.Side;

import java.util.List;

public interface SideService {
    List<Side> findAll();

    Side findById(int id);

    List<Side> findByCardId(int cardId);

    void save(Side side);

    void deleteById(int id);
}
