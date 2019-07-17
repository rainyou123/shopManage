package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.Product;
import com.service.ProductService;
import com.vo.PageBean;
import com.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/productList.do")
    public ModelAndView getAllProductByLimit(QueryVo vo){
        PageBean<Product> pageBean = productService.getAllProductByVo(vo);
        ModelAndView mac = new ModelAndView();
        mac.addObject("pageBean" , pageBean);
        mac.setViewName("product_list");
        return mac;
    }

    @RequestMapping("/ProductSearch.do")
    @ResponseBody
    public String getProductBySearch(@RequestBody String word){
        List<Product> products = productService.getProductBySearch(word);
        for(Product p:products){
            System.out.println(p);
        }
        return JSON.toJSONString(products);
    }

    @RequestMapping("/home.do")
    public String getHome(){
        return "admin/home";
    }
    @RequestMapping("/left.do")
    public String getLeft(){
        return "admin/left";
    }
    @RequestMapping("/welcome.do")
    public String getWelcome(){
        return "admin/welcome";
    }
    @RequestMapping("/bottom.do")
    public String getBottom(){
        return "admin/bottom";
    }
    @RequestMapping("/top.do")
    public String getTop(){
        return "admin/top";
    }
//    @RequestMapping("list.do")
//    public String getAllList

}
