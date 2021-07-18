package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.CategoryRepository;
import com.prismcortex.teahtv.data.DiscRepository;
import com.prismcortex.teahtv.data.MoviesRepository;
import com.prismcortex.teahtv.models.Category;
import com.prismcortex.teahtv.models.Disc;
import com.prismcortex.teahtv.models.Movies;
import com.prismcortex.teahtv.models.dto.MoviesCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MoviesController {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DiscRepository discRepository;

    @RequestMapping("movies")
    public String index (Model model) {

            model.addAttribute("title", "Home");
            model.addAttribute("movies", moviesRepository.findAll());

            return "movies";
    }

    @GetMapping("add")
    public String addNewMovie(Model model) {
        model.addAttribute("title", "Add Movie");
        model.addAttribute("movie", new Movies());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("discTypes", discRepository.findAll());
        return "add";
    }

    // find a way to add more than one category at a time for add movie
    @PostMapping("add")
    public String processAddMovieForm(@ModelAttribute @Valid Movies newMovie, Errors errors, Model model,
                                      @RequestParam int discId) {
        if(!errors.hasErrors()) {
            model.addAttribute("movies", moviesRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            moviesRepository.save(newMovie);
            return "redirect:movies";
        }
        if(newMovie != null) {
            model.addAttribute("title", "Add Movie");
            Optional<Disc> newDisc = discRepository.findById(discId);
            if(newDisc.isPresent()) {
                Disc disc = newDisc.get();
                newMovie.setDisc(disc);
            }
        }

        model.addAttribute("title", "Add Movie");
        return "redirect:add";
    }

    @GetMapping("movie/add-category")
    public String displayAddCategoryForm(@RequestParam Integer moviesId, Model model) {
        Optional<Movies> result = moviesRepository.findById(moviesId);
        Movies movie = result.get();
        model.addAttribute("title", "Add Category to: " + movie.getTitle());
        model.addAttribute("categories", categoryRepository.findAll());
        MoviesCategoryDTO movieCategory = new MoviesCategoryDTO();
        movieCategory.setMovie(movie);
        model.addAttribute("movieCategory", movieCategory);
        return "movie/add-category";
    }

    @PostMapping("add-category")
    public String processAddCategoryForm(@ModelAttribute @Valid MoviesCategoryDTO movieCategory, Model model, Errors errors) {
        if(!errors.hasErrors()) {
            Movies movie = movieCategory.getMovie();
            Category category = movieCategory.getCategory();
            if(!movie.getCategories().contains(category)) {
                movie.addCategory(category);
                moviesRepository.save(movie);
            }
            return "redirect:movies?moviesId";
        }
        return "redirect:add-category";
    }



}