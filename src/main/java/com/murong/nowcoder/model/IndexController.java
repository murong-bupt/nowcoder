package com.murong.nowcoder.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
