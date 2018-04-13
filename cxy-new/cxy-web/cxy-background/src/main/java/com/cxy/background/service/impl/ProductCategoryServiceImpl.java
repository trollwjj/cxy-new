package com.cxy.background.service.impl;

import com.cxy.background.entity.ProductCategory;
import com.cxy.background.entity.ProductCategoryExample;
import com.cxy.background.mapper.ProductCategoryMapper;
import com.cxy.background.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> listByPid(Integer pid) {
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andFlagEqualTo(true).andPidEqualTo(pid);
        return productCategoryMapper.selectByExample(example);
    }



    @Override
    public List<ProductCategory> list() {

        return productCategoryMapper.selectByExample(new ProductCategoryExample());
    }
}
