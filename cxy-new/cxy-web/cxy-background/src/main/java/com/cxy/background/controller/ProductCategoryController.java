package com.cxy.background.controller;

import com.cxy.background.entity.CategoryNode;
import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductCategory;
import com.cxy.background.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @RequestMapping("listByPid/{pid}")
    public List<CategoryNode> listByPid(@PathVariable Integer pid){
        List<ProductCategory> categories =  productCategoryService.listByPid(pid);
        List<CategoryNode> categoryNodes = new ArrayList<>(categories.size());
        for (ProductCategory category : categories) {
            CategoryNode categoryNode = new CategoryNode();
            categoryNode.setId(category.getId());
            categoryNode.setName(category.getName());
            List<CategoryNode> childrenNodes = listByPid(category.getId());
            if (childrenNodes != null && !childrenNodes.isEmpty()) {
                categoryNode.setChildren(childrenNodes);
            }
            categoryNodes.add(categoryNode);
        }
        return categoryNodes;
    }

    @RequestMapping("list")
    public List<ProductCategory> list(){

        return  productCategoryService.list();
    }
}
