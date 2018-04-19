package com.cxy.search.service;

import com.cxy.background.entity.Product;

import java.util.List;

public interface ISearcheService {
    void synAllData();

    List<Product> search(Integer pageIndex, String searchString);

    Integer getTotalCount(String searchString);

    void updateByJson(String json);

    void deleteById(Integer id);
}
