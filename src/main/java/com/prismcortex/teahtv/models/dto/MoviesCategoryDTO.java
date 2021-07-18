package com.prismcortex.teahtv.models.dto;

import com.prismcortex.teahtv.models.Category;
import com.prismcortex.teahtv.models.Movies;
import com.sun.istack.NotNull;

public class MoviesCategoryDTO {

    @NotNull
    private Movies movie;

    @NotNull
    private Category category;

    public MoviesCategoryDTO() {}

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
