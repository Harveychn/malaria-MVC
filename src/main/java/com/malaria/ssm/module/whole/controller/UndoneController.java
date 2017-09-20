package com.malaria.ssm.module.whole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 郑晓辉 on 2016/11/29.
 */
@Controller
@RequestMapping("/UndonePage")
public class UndoneController {
    @RequestMapping("/developing")
    public String developing()throws Exception{
        return "common/unDone";
    }

    @RequestMapping("/hotMapDemo")
    public String hotMapDemo()throws Exception{
        return "common/hotMap";
    }
}
