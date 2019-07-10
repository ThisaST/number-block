package com.arbiter.numberblock.controller;

import com.arbiter.numberblock.modal.NumberBlock;
import com.arbiter.numberblock.service.NumberBlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Slf4j
@Controller
public class NumberBlockController {

    private final NumberBlockService numberBlockService;

    public NumberBlockController(NumberBlockService numberBlockService) {
        this.numberBlockService = numberBlockService;
    }

    @RequestMapping(value = {"/", "/index", "/index.html", "/loadData"})
    public String index(Model model) {
        ArrayList<Integer> outerCards = new ArrayList<>();
        ArrayList<String> padNumbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            outerCards.add(i);
        }

        String number;
        for (int i = 1; i <= 56; i++) {
            if (i <= 9) {
                number = "0" + i;
                padNumbers.add(number);
            } else {
                number = String.valueOf(i);
                padNumbers.add(number);
            }

        }
        model.addAttribute("numberBlock", new NumberBlock());
        model.addAttribute("outerCards", outerCards);
        model.addAttribute("padNumbers", padNumbers);
        model.addAttribute("numberBlocks", numberBlockService.findAll());

        return "index";
    }

    @RequestMapping(value = {"saveNumberBlock"})
    public String saveData(Model model) {


        return "index";
    }
}
