package com.prismcortex.teahtv.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disc extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "disc")
    private final List<Movies> movies = new ArrayList<>();

    public Disc(String name) {
        this.name=name;
    }

    public Disc() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
