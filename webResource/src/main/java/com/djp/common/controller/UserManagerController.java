package com.djp.common.controller;

import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dengjianping on 2015/8/14.
 */
@Controller
@RequestMapping("/pages")
public class UserManagerController {
    @Resource
    private UserService userService;
//    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/userInfo/{username}")
    public ModelAndView userInfo(@PathVariable String username){
        User user = userService.findByUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userManage/userInfo");
        modelAndView.addObject("user", user);
        List<String> permissions = userService.findPermissions(user);
        List<String> roles = userService.findRoles(user);
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("permissions",permissions);
        return modelAndView;
    }

    /**
     * 返回登录页面
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String login(){
        return "/login";
    }
    /**
     * 返回登录页面
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(@ModelAttribute User user,Model model,HttpServletRequest request,HttpServletResponse response){
        String message = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try{
            subject.login(token);
            HttpSession session = request.getSession();
            User userifno = userService.findByUsername((String) subject.getPrincipal());
            session.setAttribute("userInfo", userifno);
            model.addAttribute("user", userifno);
            Cookie[] cookies = request.getCookies();

            if(cookies!=null){
                for (Cookie cookie:cookies){
                    cookie.setMaxAge(24*60*60);
                    response.addCookie(cookie);
                }
            }
        }catch (AuthenticationException e){
            message = "登录失败！";
            model.addAttribute("error", "用户名或密码错误 ！");
            return "/login";
        }

        return "/console/console";
    }

    /**
     * 返回无权限页面
     * @return
     */
    @RequestMapping(value = "/unauthorized" ,method = RequestMethod.GET)
    public String unauthorized(){
        return "/unauthorized";
    }
}
