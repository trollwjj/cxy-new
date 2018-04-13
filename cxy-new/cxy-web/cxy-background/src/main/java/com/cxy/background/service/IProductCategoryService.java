package com.cxy.background.service;

import com.cxy.background.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> listByPid(Integer pid);

    List<ProductCategory> list();
}
