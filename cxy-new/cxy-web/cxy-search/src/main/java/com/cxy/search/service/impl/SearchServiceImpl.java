package com.cxy.search.service.impl;

import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductExample;
import com.cxy.background.mapper.ProductMapper;
import com.cxy.search.service.ISearcheService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class SearchServiceImpl implements ISearcheService {

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void synAllData() {
        ProductExample example = new ProductExample();
        example.createCriteria().andFlagEqualTo(true);
        List<Product> productList = productMapper.selectByExample(example);
        for (Product product : productList) {

            SolrInputDocument solrDocument = new SolrInputDocument();
            solrDocument.setField("product_name", product.getName());
            solrDocument.setField("product_price", product.getPrice());
            solrDocument.setField("sale_point", product.getSalePoint());
            solrDocument.setField("id", product.getId());
            solrDocument.setField("images", product.getImages());
            try {
                solrServer.add(solrDocument);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> search(Integer pageIndex, String searchString) {

        if (pageIndex== null){
            pageIndex = 1;
        }

        SolrQuery query = new SolrQuery();
        if (searchString == null || searchString.isEmpty()){
            query.setQuery("product_keywords:*");

        }else {
            query.setQuery("product_keywords:"+searchString);
            query.setHighlight(true);
            query.addHighlightField("product_name");
            query.addHighlightField("sale_point");
            query.setHighlightSimplePre("<font color='red'>");
            query.setHighlightSimplePost("</font>");
        }

        try {
            int pageSize = 2;
            query.setStart((pageIndex-1)*pageSize);
            query.setRows(pageSize);

            QueryResponse response = solrServer.query(query);

            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

            SolrDocumentList results = response.getResults();
            List<Product> productList = new ArrayList<>();
            for (SolrDocument result : results) {
                Product product = new Product();
                product.setId(Integer.parseInt(result.getFieldValue("id").toString()));
                product.setImages(result.getFieldValue("images").toString());
                product.setPrice(Integer.parseInt(result.getFieldValue("product_price").toString()));

                if (highlighting!=null){
                    List<String> nameHilight = highlighting.get(result.getFieldValue("id")).get("product_name");
                    if (nameHilight !=null && !nameHilight.isEmpty()){
                        product.setName(nameHilight.get(0));
                    }else {
                        product.setName(result.getFieldValue("product_name").toString());
                    }

                    List<String> salePointHilight = highlighting.get(result.getFieldValue("id")).get("sale_point");
                    if (salePointHilight != null && !salePointHilight.isEmpty()){
                        product.setSalePoint(salePointHilight.get(0));
                    }else{
                        product.setSalePoint(result.getFieldValue("sale_point").toString());

                    }
                }else {
                        product.setSalePoint(result.getFieldValue("sale_point").toString());
                        product.setName(result.getFieldValue("product_name").toString());

                }
                productList.add(product);
            }

            return productList;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Integer getTotalCount(String searchString) {

        SolrQuery query = new SolrQuery();
        if (searchString == null || searchString.isEmpty()){
            query.setQuery("product_keywords:*");

        }else {
            query.setQuery("product_keywords:"+searchString);
        }

        try {
            QueryResponse response = solrServer.query(query);
            return (int) response.getResults().getNumFound();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

        return  0;
    }
}
