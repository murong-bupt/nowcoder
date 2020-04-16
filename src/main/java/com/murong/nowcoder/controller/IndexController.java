package com.murong.nowcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author xdy
 */
@Controller
public class IndexController {
    @RequestMapping(path = {"/","/index"})
    @ResponseBody
    public String index(){
        return "Hello, Nowcoder XDY!";
    }

    /**
     * 基本参数解析方法
     */
    @RequestMapping(value = "/profile/{groupId}/{userId}")
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type",defaultValue = "1") int type,
                          @RequestParam(value = "key",
                                  defaultValue = "nowcoder") String key){
        return String.format("This is the profile page of " +
                "%s组的%d号用户，type为%d,key为%s",groupId,userId,type,key);
    }

    @RequestMapping(value = "/vm",method = RequestMethod.GET)
    public String template(){
        return "home.html";
    }

}
