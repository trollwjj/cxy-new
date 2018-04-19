package com.cxy.search.handler;

import com.cxy.search.service.ISearcheService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductHandler {
    @Autowired
    private ISearcheService searcheService;
    public void addProduct(String json){
        System.out.println(json);
        searcheService.updateByJson(json);
    }


    public void deleteProduct(Integer id){
        System.out.println("productId = " + id);
        searcheService.deleteById(id);
    }

}
