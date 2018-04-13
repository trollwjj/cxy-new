package com.cxy.background.service.impl;

import com.cxy.background.entity.ProductExample;
import com.cxy.background.entity.ProductVo;
import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductDesc;
import com.cxy.background.mapper.ProductDescMapper;
import com.cxy.background.mapper.ProductMapper;
import com.cxy.background.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDescMapper productDescMapper;


    @Override
    public int uploadProduct(ProductVo productVo) {
        Product product = productVo.getProduct();
        productMapper.insertSelective(product);
        ProductDesc productDesc = new ProductDesc();
        productDesc.setProductId(product.getId());
        productDesc.setProductDesc(productVo.getProductDesc());
        return productDescMapper.insertSelective(productDesc);
    }

    @Override
    public List<Product> productList() {

        ProductExample example = new ProductExample();
        example.createCriteria().andFlagEqualTo(true);

        List<Product> productList = productMapper.selectByExample(example);
        return productList;
    }

    @Override
    public ProductVo getProductVoById(Integer productId) {

        ProductVo productVo = productMapper.selectByProductId(productId);

        return productVo;
    }

    @Override
    public int updateProduct(ProductVo productVo) {
        int result = productMapper.updateByProductVo(productVo);
        result += productDescMapper.updateByProductVo(productVo);
        return  result;
    }

    @Override
    public int deleteProductById(Integer productId) {
        ProductExample example= new ProductExample();
        example.createCriteria().andIdEqualTo(productId);
        Product product = new Product();
        product.setId(productId);
        product.setFlag(false);
        return productMapper.updateByExampleSelective(product,example);
    }

    @Override
    public int deleteProductsByIds(List<Integer> ids) {

        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        Product product = new Product();
        product.setFlag(false);
        return productMapper.updateByExampleSelective(product, example);
    }

}
