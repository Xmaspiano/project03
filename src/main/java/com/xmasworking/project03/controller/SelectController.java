package com.xmasworking.project03.controller;

import com.xmasworking.project03.entity.SelectedDetail;
import com.xmasworking.project03.service.SelectedDetailService;
import com.xmasworking.project03.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @Autowired
    private SelectedDetailService selectedDetailService;

    @RequestMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("select");
        if (selectedDetailService.hasCommitByTel()) {
            modelAndView.setViewName("redirect:/rank");
        }

        modelAndView.addObject("Selections",selectionService.findAlLSelectionByAllDept());
        return modelAndView;
    }

    @PostMapping("commit")
    public String commit(@RequestBody List<SelectedDetail> selectedDetail){
        if(false == selectedDetailService.hasCommitByTel()) {
            selectedDetailService.saveByLevelRoleScore(selectedDetail);
        }
        return "redirect:/rank/forword";
    }
}

