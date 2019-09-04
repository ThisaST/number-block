package com.arbiter.numberblock.controller;

import com.arbiter.numberblock.modal.Draws;
import com.arbiter.numberblock.modal.DrawsJsonMapper;
import com.arbiter.numberblock.modal.NumberBlock;
import com.arbiter.numberblock.modal.NumberBlockJsonMapper;
import com.arbiter.numberblock.service.DrawsService;
import com.arbiter.numberblock.service.NumberBlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created By Praneeth On 08/07/2019 for numberblock v1.0
 */

@Slf4j
@Controller
public class NumberBlockController {

    private final NumberBlockService numberBlockService;
    private final DrawsService drawsService;

    public NumberBlockController(NumberBlockService numberBlockService, DrawsService drawsService) {
        this.numberBlockService = numberBlockService;
        this.drawsService = drawsService;
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
    public String saveData(Model model, @RequestBody NumberBlockJsonMapper numberBlockJsonMapper) {
        indexData(model);
        for (int i = 0; i < numberBlockJsonMapper.getNumberBlockList().size(); i++) {
            Date date = numberBlockJsonMapper.getNumberBlockList().get(i).getDate();
            String numberCombination = numberBlockJsonMapper.getNumberBlockList().get(i).getNumberCombination();
            String pickType = numberBlockJsonMapper.getNumberBlockList().get(i).getPickType();
            BigDecimal cost = numberBlockJsonMapper.getNumberBlockList().get(i).getCost();
            Integer hits = numberBlockJsonMapper.getNumberBlockList().get(i).getHits();
            Integer checked = numberBlockJsonMapper.getNumberBlockList().get(i).getChecked();

            NumberBlock numberBlock = new NumberBlock();
            numberBlock.setDate(date);
            numberBlock.setNumberCombination(numberCombination);
            numberBlock.setPickType(pickType);
            numberBlock.setCost(cost);
            numberBlock.setHits(hits);
            numberBlock.setChecked(checked);

//          Save Data
            numberBlockService.save(numberBlock);
        }
        return "Success";
    }

    @PostMapping(value = {"/updateNumberBlock", "/loadData/updateNumberBlock"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String updateData(Model model, NumberBlock numberBlock) {
        indexData(model);
        // Update Data
        log.info("numberBlock 111111111: {}", numberBlock.toString());
        numberBlockService.update(numberBlock);
        return "Success";
    }

    @RequestMapping(value = {"/saveDraws", "/loadData/saveDraws"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Draws saveDrawsData(Model model, @RequestBody DrawsJsonMapper drawsJsonMapper) {
        indexData(model);
        Draws resultDraws = new Draws();
        for (int i = 0; i < drawsJsonMapper.getDrawsList().size(); i++) {
            Date date = drawsJsonMapper.getDrawsList().get(i).getDate();
            String numberCombination = drawsJsonMapper.getDrawsList().get(i).getNumberCombination();

            log.info("date {}", date);
            log.info("numberCombination {}", numberCombination);

            Draws draws = new Draws();
            draws.setDate(date);
            draws.setNumberCombination(numberCombination);

//          Save Data
            resultDraws = drawsService.save(draws);
        }

        return resultDraws;
    }

    @PostMapping(value = {"/updateDraws", "/loadData/updateDraws"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String updateDrawsData(Model model, Draws draws) {
        indexData(model);
        // Save Data
        drawsService.save(draws);
        return "success";
    }

    @GetMapping(value = {"/loadCompareList", "/loadData/loadCompareList"})
    @ResponseBody
    public List<NumberBlock> loadCompareData() {
        List<NumberBlock> resultList = numberBlockService.findAllByDate(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().minusDays(7)));
        return resultList;
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
        model.addAttribute("winningNumber", drawsService.findTop1ByOrderByIdDesc());
        model.addAttribute("numberBlockDraws", drawsService.findAllNumberBlockDraws());
    }
}
