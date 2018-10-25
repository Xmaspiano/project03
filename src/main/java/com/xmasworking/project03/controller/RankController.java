package com.xmasworking.project03.controller;

import com.xmasworking.project03.entity.DepartmentInfo;
import com.xmasworking.project03.entity.SelectedDetail;
import com.xmasworking.project03.entity.TelInfo;
import com.xmasworking.project03.model.RankModel;
import com.xmasworking.project03.repository.DepartmentInfoRepository;
import com.xmasworking.project03.service.SelectedDetailService;
import com.xmasworking.project03.util.Common;
import com.xmasworking.project03.util.EntityListToMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 上午11:24
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private EntityListToMap<DepartmentInfo> entityListToMap;

    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    private SelectedDetailService selectedDetailService;

    @RequestMapping
    public ModelAndView index(){
        Map<Long, DepartmentInfo> depts = entityListToMap.toMap(departmentInfoRepository.findAll());
        List<Map> rankModels = selectedDetailService.getDeptSelectionTotleScoreByYM(Common.getDateYM());
        ModelAndView modelAndView = new ModelAndView("rank");
        modelAndView.addObject("allSroce",rankModels);
        return modelAndView;
    }

    @RequestMapping(value = "/forword")
    @ResponseBody
    public Map forword() {
        Map map = new HashMap(16);
        map.put("forword", "/rank");
        map.put("status", true);
        map.put("error", "操作成功");
        return map;
    }
}

