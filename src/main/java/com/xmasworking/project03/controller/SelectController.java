package com.xmasworking.project03.controller;

import com.xmasworking.project03.entity.SelectedDetail;
import com.xmasworking.project03.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @PostMapping("commit")
    public String commit(@RequestBody SelectedDetail[] selectedDetail){
        for(SelectedDetail ss:selectedDetail){
            System.out.println(ss);
        }
        return "";
    }

}

