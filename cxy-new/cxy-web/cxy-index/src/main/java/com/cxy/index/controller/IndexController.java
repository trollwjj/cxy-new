package com.cxy.index.controller;

import com.cxy.common.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
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
//        String url=  "redirect:http://localhost:8082/search/search?pageIndex=1&searchString="+searchString;
        try {
            String encode = URLEncoder.encode(searchString, "utf-8");
            String url=  "redirect:http://localhost:8082/search/search?searchString="+encode+"&pageIndex=1";
            System.out.println(url);
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
