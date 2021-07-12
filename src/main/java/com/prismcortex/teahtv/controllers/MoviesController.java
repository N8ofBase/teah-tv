package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.MoviesRepository;
import com.prismcortex.teahtv.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MoviesController {

    @Autowired
    private MoviesRepository moviesRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("movies", moviesRepository.findAll());
        return "movies";
    }

    @GetMapping("add")
    public String addNewMovie(Model model) {
        model.addAttribute("title", "Add Movie");
        model.addAttribute(new Movies());
        return "add";
    }

    @PostMapping("add")
    public String processAddMovieForm(@ModelAttribute @Valid Movies newMovie, Error errors, Model model) {
        return "add";
    }


}