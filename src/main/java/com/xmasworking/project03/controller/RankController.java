package com.xmasworking.project03.controller;

import com.xmasworking.project03.entity.TelInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    private TelInfo telInfo;

    @RequestMapping
    public String index(){
        return "rank";
    }
}

