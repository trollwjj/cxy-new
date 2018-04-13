package com.cxy.background.controller;

import com.cxy.background.entity.Product;
import com.cxy.background.entity.ProductVo;
import com.cxy.background.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @ResponseBody
    @RequestMapping("addProduct")
    public String addProduct(ProductVo productVo){

        int result = productService.uploadProduct(productVo);

        if (result > 0){
            return  "true";
        }
        return "false";
    }

    @RequestMapping("productList/{pageIndex}")
    public String productList(Model model, @PathVariable Integer pageIndex){

        PageHelper.startPage(pageIndex,2);
        List<Product> productList = productService.productList();
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList, 3);
        model.addAttribute("pageInfo", pageInfo);
        return "/productList";
    }

    @RequestMapping("showAddProduct")
    public String showAddProduct(Integer pageIndex, Model model){
       model.addAttribute("pageIndex", pageIndex);
        return "/addProduct";
    }

    @RequestMapping("showUpdateProduct")
    public String showUpdateProduct(Integer productId, Integer pageIndex, Model model){
        ProductVo productVo = productService.getProductVoById(productId);
        model.addAttribute("productVo",productVo);
        model.addAttribute("pageIndex",pageIndex);
        return "/updateProduct";
    }

    @RequestMapping("updateProduct")
    @ResponseBody
    public String updateProduct(ProductVo productVo){

        int result = productService.updateProduct(productVo);
        if (result > 0){
            return  "true";
        }
        return  "false";
    }


    @RequestMapping("deleteProduct/{productId}")
    @ResponseBody
    public String deleteProduct(@PathVariable Integer productId){
        int result = productService.deleteProductById(productId);
        if (result > 0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("deleteProducts")
    @ResponseBody
    public String deleteProducts(HttpServletRequest request){
        String[] idsString = request.getParameterValues("ids[]");
        List<Integer> ids = new ArrayList<>();
        for (String s : idsString) {
            ids.add(Integer.parseInt(s));
        }
        int result = productService.deleteProductsByIds(ids);
        System.out.println("================"+result);

        if (result > 0){
            return "true";
        }
        return "false";
    }


}
