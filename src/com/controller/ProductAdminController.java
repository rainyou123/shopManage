package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductAdminController {
    @Autowired
    private ProductService productService;
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
    @RequestMapping("/list.do")
    public String getAllList(Model model){
        List<Product> productList = productService.getAllAdminProduct();
        model.addAttribute("productList" , productList);
        return "admin/product/list";
    }
}
