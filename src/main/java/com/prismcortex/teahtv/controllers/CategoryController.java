package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.CategoryRepository;
import com.prismcortex.teahtv.models.Category;
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
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/index";
    }

    @GetMapping("add")
    public String addCategoryForm(Model model) {
        model.addAttribute(new Category());
        return "category/add";

    }

    @PostMapping("add")
    public String processAddCategoryForm(@ModelAttribute @Valid Category newCategory, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "category/add";
        }
        model.addAttribute("title", "Add Category");
        categoryRepository.save(newCategory);

        return "redirect:";
    }
}
