package com.prismcortex.teahtv.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Movies extends AbstractEntity{


    @NotBlank
    private String title;

    @NotNull(message = "Must enter year released")
    private int year_released;

    @NotBlank
    private String director;

    @NotBlank
    private Category category;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @NotNull
    private Disc disc;

    @NotBlank
    private String location;

    public Movies() {
    }

    public Movies(String aTitle, int aYear_released, String aDirector, Category aCategory,
                  Disc aDisc, String aLocation) {
        this.title = aTitle;
        this.year_released = aYear_released;
        this.director = aDirector;
        this.category = aCategory;
        this.disc = aDisc;
        this.location = aLocation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear_released() {
        return year_released;
    }

    public void setYear_released(int year_released) {
        this.year_released = year_released;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List getCategories() {
        return categories;
    }

    public Category getCategory(){return category;}

    public void setCategory(Category category) {
        this.category = category;
    }

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    @Override
    public String toString() {return title;}


}