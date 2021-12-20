package com.prismcortex.teahtv.models;


import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity{
    @NotNull(message = "Name required")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private final List<Movies> movies = new ArrayList<>();

    public Category() {}

    public Category(String categoryName) {
        this.categoryName=categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    @Override
    public String toString() {return categoryName;}
}
