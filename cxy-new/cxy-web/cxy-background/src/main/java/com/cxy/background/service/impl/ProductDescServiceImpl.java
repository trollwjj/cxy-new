package com.cxy.background.service.impl;

import com.cxy.background.entity.ProductDesc;
import com.cxy.background.mapper.ProductDescMapper;
import com.cxy.background.service.IProductDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDescServiceImpl implements IProductDescService {

    @Autowired
    private ProductDescMapper productDescMapper;

    @Override
    public int saveProductDesc(ProductDesc productDesc) {

        return productDescMapper.insertSelective(productDesc);
    }
}
