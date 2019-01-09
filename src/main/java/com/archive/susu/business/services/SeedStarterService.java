package com.archive.susu.business.services;

import com.archive.susu.business.entities.SeedStarter;

import java.util.List;

public interface SeedStarterService {
    List<SeedStarter> findAll();

    void add(final SeedStarter seedStarter);
}
