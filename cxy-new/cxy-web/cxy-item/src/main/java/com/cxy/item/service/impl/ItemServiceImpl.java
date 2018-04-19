package com.cxy.item.service.impl;

import com.cxy.background.entity.Product;
import com.cxy.item.service.ItemService;
import com.google.gson.Gson;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService, ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void createDetailPage(String json) {
        Gson gson = new Gson();
        Product product = gson.fromJson(json, Product.class);
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = null;
        Writer out = null;
        try {
            template = configuration.getTemplate("product_detail.html");
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("product", product);
            String contextPath = servletContext.getContextPath();
            dataModel.put("basePath",contextPath);
            String parentPath = servletContext.getRealPath("/product");
            File file = new File(parentPath, product.getId()+".html");
            out = new FileWriter(file);
            template.process(dataModel, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (out !=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
