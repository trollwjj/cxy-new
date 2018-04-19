package com.cxy.item.controller;

import com.cxy.common.pojo.State;
import com.cxy.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("item")
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping("createDetailPage")
    @ResponseBody
    public String createDetailPage(@RequestBody String json) {

        itemService.createDetailPage(json);

        return State.SUCCESS;
    }
}
