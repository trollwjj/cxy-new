package com.cxy.index.controller;

import com.cxy.common.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = "listCategoryByPid", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String listCategoryByPid(Integer pid, String callback){
        String string = HttpClientUtils.doGet("http://localhost:8080/productCategory/listByPid/" + pid);
        System.out.println(string);
        return  callback+"("+string+")";
    }


    @RequestMapping("search")
    public String search(String searchString){

        return "redirect:http://localhost:8082/search/search?searchString="+searchString;
    }
}
