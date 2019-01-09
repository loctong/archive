package com.archive.susu.business.services.impl;

import com.archive.susu.business.entities.Variety;
import com.archive.susu.business.entities.repository.VarietyRepository;
import com.archive.susu.business.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyServiceImpl implements VarietyService {

    @Autowired
    private VarietyRepository varietyRepository;

    public List<Variety> findAll() {
        return this.varietyRepository.findAll();
    }

    public Variety findById(final Integer id) {
        return this.varietyRepository.findById(id);
    }
}
