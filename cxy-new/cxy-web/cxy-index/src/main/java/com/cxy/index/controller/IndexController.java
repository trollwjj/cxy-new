package com.cxy.index.controller;

import com.cxy.background.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ValueConstants;

@Controller
public class IndexController {

    @RequestMapping(value = "listCategoryByPid", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String listCategoryByPid(Integer pid, String callback){
        String string = HttpClientUtils.doGet("http://localhost:8080/productCategory/listByPid/" + pid);
        System.out.println(string);
        return  callback+"("+string+")";
    }
}
