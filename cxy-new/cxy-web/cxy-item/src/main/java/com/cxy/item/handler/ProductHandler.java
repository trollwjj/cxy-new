package com.cxy.item.handler;

import com.cxy.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductHandler {

    @Autowired
    private ItemService itemService;

    public void addProduct(String json){
        System.out.println(json);
        itemService.createDetailPage(json);
    }

}
