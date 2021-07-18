package com.prismcortex.teahtv.controllers;

import com.prismcortex.teahtv.data.DiscRepository;
import com.prismcortex.teahtv.models.Disc;
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
@RequestMapping("disc")
public class DiscController {

    @Autowired
    private DiscRepository discRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Disc Types");
        model.addAttribute("discTypes", discRepository.findAll());
        return "disc/index";
    }

    @GetMapping("add")
    public String addDiscForm(Model model) {
        model.addAttribute(new Disc());
        return "disc/add";

    }

    @PostMapping("add")
    public String processAddDiscForm(@ModelAttribute @Valid Disc newDisc, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "disc/add";
        }
        model.addAttribute("title", "Add Disc Type");
        discRepository.save(newDisc);

        return "redirect:";
    }
}
