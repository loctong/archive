package com.archive.susu.business.entities.repository;

import com.archive.susu.business.entities.SeedStarter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeedStartedRepository {

    private final List<SeedStarter> seedStarters = new ArrayList<>();

    public List<SeedStarter> findAll() {
        return new ArrayList<>(this.seedStarters);
    }

    public void add(SeedStarter seedStarter) {
        this.seedStarters.add(seedStarter);
    }
}
