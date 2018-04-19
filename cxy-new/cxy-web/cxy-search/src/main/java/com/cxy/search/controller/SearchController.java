package com.cxy.search.controller;

import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductExample;
import com.cxy.background.mapper.ProductMapper;
import com.cxy.common.pojo.State;
import com.cxy.search.pojo.PageInfo;
import com.cxy.search.service.ISearcheService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "search")
public class SearchController {



    @Autowired
    private ISearcheService searcheService;


    @RequestMapping("synAllData")
    @ResponseBody
    public String synAllData() {




        searcheService.synAllData();

        return State.SUCCESS;
    }


    @RequestMapping("updateById/{id}")
    public  String updatePyId(@PathVariable Integer id){

        return State.SUCCESS;
    }

    @RequestMapping("updateByJson")
    @ResponseBody
    public String updateByJson(@RequestBody String json){
        searcheService.updateByJson(json);
        return State.SUCCESS;
    }


    @RequestMapping("search")
    public String search(Integer pageIndex, String searchString, Model model){


        System.out.println(pageIndex);
        System.out.println(searchString);

        if (pageIndex == null){
            pageIndex = 1;
        }

        List<Product> productList = searcheService.search( pageIndex ,searchString);
        Integer totalCount = searcheService.getTotalCount(searchString);

        PageInfo<Product> pageInfo = new PageInfo<>();
        pageInfo.setList(productList);
        pageInfo.setPageSize(2);
        pageInfo.setTotal(totalCount);
        pageInfo.setPageNum(pageIndex);
        pageInfo.setNavigatePages(3);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("searchString", searchString);

        return "searchList";
    }
}
