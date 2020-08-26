package com.freeroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李发展
 * @date 2020-8-26 - 14:22
 */
@Controller
public class PageController {

    @GetMapping({"/","/index"})
    public String indexPage(){
        return "index";
    }

}
