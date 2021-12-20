package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.CategoryRepository;
import com.prismcortex.teahtv.models.Category;
import com.prismcortex.teahtv.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("category")
    @GetMapping("category")
    public String displayCategories(Model model) {
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/index";
    }


    @GetMapping("category/add")
    public String addCategories(Model model) {
        model.addAttribute("title", "Add Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("category/add")
    public String createCategory(@ModelAttribute @Valid Category newCategory, Errors errors, Model model) {
        if (!errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            model.addAttribute("movies", categoryRepository.findAll());

            categoryRepository.save(newCategory);
            return "redirect:add";
        }
        return "category/add";
    }
}
