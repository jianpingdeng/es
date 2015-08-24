package com.djp.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dengjianping on 2015/8/11.
 */
@Controller
public class PageController {
    Logger log = LoggerFactory.getLogger(PageController.class);
    @RequestMapping("/pages/index")
    public String index(){
        return "/index";
    }
}
