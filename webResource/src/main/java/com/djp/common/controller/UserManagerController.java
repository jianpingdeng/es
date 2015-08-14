package com.djp.common.controller;

import com.djp.common.entity.User;
import com.djp.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dengjianping on 2015/8/14.
 */
@Controller
@RequestMapping("/pages")
public class UserManagerController {
    @Resource
    private UserService userService;

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
}
