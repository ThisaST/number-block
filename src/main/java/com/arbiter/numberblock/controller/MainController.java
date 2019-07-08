package com.arbiter.numberblock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Controller
public class MainController {

    int[] values = {1, 2, 3, 4, 5, 6, 7};

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("values", values);

        return "index";
    }
}
