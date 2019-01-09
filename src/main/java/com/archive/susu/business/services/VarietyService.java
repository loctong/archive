package com.archive.susu.business.services;

import com.archive.susu.business.entities.Variety;

import java.util.List;

public interface VarietyService {
    List<Variety> findAll();

    Variety findById(final Integer id);
}
