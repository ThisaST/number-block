package com.arbiter.numberblock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("message", "NUMBER");

        return "index";
    }
}
