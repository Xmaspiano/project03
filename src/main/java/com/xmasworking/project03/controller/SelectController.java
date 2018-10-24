package com.xmasworking.project03.controller;

import com.xmasworking.project03.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 上午11:24
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/select")
public class SelectController {

    @Autowired
    private SelectionService selectionService;

    @RequestMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("select");
        modelAndView.addObject("Selections",selectionService.findAlLSelectionByAllDept());
        return modelAndView;
    }


}

