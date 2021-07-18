package com.prismcortex.teahtv.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Category extends AbstractEntity{

    @Size(min=3, message="Category must be at least 3 characters.")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private final List<Movies> movies = new ArrayList<>();

    public Category(@Size(min=3, message="Category must be at least 3 characters.") String name) {
        this.name=name;
    }

    public Category() {}

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
