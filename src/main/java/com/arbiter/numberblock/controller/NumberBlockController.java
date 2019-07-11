package com.arbiter.numberblock.controller;

import com.arbiter.numberblock.modal.NumberBlock;
import com.arbiter.numberblock.modal.NumberBlockData;
import com.arbiter.numberblock.service.NumberBlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

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

    @RequestMapping(value = {"/", "/index", "/index.html",})
    public String index(Model model) {
        indexData(model);
        return "index";
    }

    @RequestMapping(value = "/loadData", method = RequestMethod.GET)
    public String loadData(Model model) {
        indexData(model);
        return "index";
    }

    @RequestMapping(value = {"/saveNumberBlock", "/loadData/saveNumberBlock"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveData(Model model, @RequestBody NumberBlockData numberBlockData) {
        indexData(model);
        log.info("SIZE : " + numberBlockData.getNumberBlockList().size());
        for (int i = 0; i < numberBlockData.getNumberBlockList().size(); i++) {
            Date date = numberBlockData.getNumberBlockList().get(i).getDate();
            String numberCombination = numberBlockData.getNumberBlockList().get(i).getNumberCombination();
            String pickType = numberBlockData.getNumberBlockList().get(i).getPickType();
            BigDecimal cost = numberBlockData.getNumberBlockList().get(i).getCost();

            log.info("Date : " + date);
            log.info("numberCombination : " + numberCombination);
            log.info("pickType : " + pickType);
            log.info("cost : " + cost);

            NumberBlock numberBlock = new NumberBlock();
            numberBlock.setDate(date);
            numberBlock.setNumberCombination(numberCombination);
            numberBlock.setPickType(pickType);
            numberBlock.setCost(cost);
            model.addAttribute("result", numberBlockService.save(numberBlock));
        }
        model.addAttribute("numberBlocks", numberBlockService.findAll());
        return "index";
    }

    private void indexData(Model model) {
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
    }
}
