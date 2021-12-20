package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.CategoryRepository;
import com.prismcortex.teahtv.data.MoviesRepository;
import com.prismcortex.teahtv.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MoviesController {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("movies")
    @GetMapping("movies")
    public String index (Model model) {

            model.addAttribute("title", "Home");
            model.addAttribute("movie", moviesRepository.findAll());
            model.addAttribute("movie", new Movies());
            return "movies";
    }

    // find a way to add more than one category at a time for add movie
    @PostMapping("movies")
    public String processAddMovieForm(@ModelAttribute @Valid Movies newMovie, Errors errors, Model model) {
        if (!errors.hasErrors()) {
            model.addAttribute("title", "Add Movie");
            model.addAttribute("movies", moviesRepository.findAll());

            moviesRepository.save(newMovie);
            return "redirect:movies";
        }
        return "movies";
    }


//    @GetMapping("movie/add-category")
//    public String displayAddCategoryForm(@RequestParam Integer moviesId, Model model) {
//        Optional<Movies> result = moviesRepository.findById(moviesId);
//        Movies movie = result.get();
//        model.addAttribute("title", "Add Category to: " + movie.getTitle());
//        model.addAttribute("categories", categoryRepository.findAll());
//        MoviesCategoryDTO movieCategory = new MoviesCategoryDTO();
//        movieCategory.setMovie(movie);
//        model.addAttribute("movieCategory", movieCategory);
//        return "movie/add-category";
//    }

//    @PostMapping("add-category")
//    public String processAddCategoryForm(@ModelAttribute @Valid MoviesCategoryDTO movieCategory, Model model, Errors errors) {
//        if(!errors.hasErrors()) {
//            Movies movie = movieCategory.getMovie();
//            Category category = movieCategory.getCategory();
//            if(!movie.getCategories().contains(category)) {
//                movie.addCategory(category);
//                moviesRepository.save(movie);
//            }
//            return "redirect:movies?moviesId";
//        }
//        return "redirect:add-category";
//    }



}