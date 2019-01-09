package com.archive.susu.business.services.impl;

import com.archive.susu.business.entities.SeedStarter;
import com.archive.susu.business.entities.repository.SeedStartedRepository;
import com.archive.susu.business.services.SeedStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedStarterServiceImpl implements SeedStarterService {

    @Autowired
    private SeedStartedRepository seedstarterRepository;

    @Override
    public List<SeedStarter> findAll() {
        return this.seedstarterRepository.findAll();
    }

    @Override
    public void add(SeedStarter seedStarter) {
        this.seedstarterRepository.add(seedStarter);
    }
}
