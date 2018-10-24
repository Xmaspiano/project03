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
@RequestMapping("/login")
public class LoginController {
    private TelInfo telInfo;

    @RequestMapping
    public String index(){
        return "login";
    }

    @RequestMapping("/checkcode")
    public ModelAndView checkcode(@RequestParam("invite_code") String inviteCode, HttpSession httpSession){
        String error = "";
        if("".equals(inviteCode)) {
            error ="手机号不能为空！！！";
        }else {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(inviteCode, "");
            Subject subject = SecurityUtils.getSubject();
            try {
                //完成登录
                subject.login(usernamePasswordToken);
                ModelAndView modelAndView = new ModelAndView("redirect:/select");
                return modelAndView;
            } catch (UnknownAccountException uae) {
                error = "用户不存在,请申请用户!!!";
            } catch (IncorrectCredentialsException ice) {
                error = "用户名密码错误,请确认后重新登陆!!!";
            } catch (LockedAccountException lae) {
                error = "账户已被锁定，无法登陆!!!";
            } catch (AuthenticationException ae) {
                error = "unexpected condition...";
            } catch(Exception e) {
                error = "登录异常：" + e.getMessage();
            }
        }

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("msg", error);
        return modelAndView;
    }
}

