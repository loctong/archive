package com.archive.susu.business.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SeedStarter {
    private Integer id = null;
    private Date datePlanted = null;
    private Boolean covered = null;
    private Type type = Type.PLASTIC;
    private Feature[] features = null;

    private List<Row> rows = new ArrayList<>();
}
