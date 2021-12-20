package com.prismcortex.teahtv.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movies extends AbstractEntity{

    @NotBlank
    private String location;

    @NotBlank
    private String title;

    @NotBlank
    private String director;

    @NotNull(message = "Must enter year released")
    private int year;

    @ManyToOne
    @NotNull(message = "Category is required")
    private Category category;

    @NotNull
    private String format;

    private String notes;



    public Movies() {
    }

    public Movies(String location, String title, String director, int year,
                  Category category, String format, String notes) {
        this.location=location; this.title = title; this.director=director;
        this.year=year; this.category=category; this.format=format; this.notes=notes;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Category getCategory(){return category;}

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {return title;}


}