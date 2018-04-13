package com.cxy.background.service;

import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductVo;

import java.util.List;

public interface IProductService {
    int uploadProduct(ProductVo productVo);

    List<Product> productList();

    ProductVo getProductVoById(Integer productId);

    int updateProduct(ProductVo productVo);

    int deleteProductById(Integer productId);

    int deleteProductsByIds(List<Integer> ids);
}
