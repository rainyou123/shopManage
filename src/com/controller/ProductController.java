package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.Product;
import com.service.ProductService;
import com.vo.PageBean;
import com.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/productList.do")
    public String getAllProductByLimit(QueryVo vo , Model model){
        PageBean<Product> pageBean = productService.getAllProductByVo(vo);
        model.addAttribute("pageBean" , pageBean);
        return "product_list";
    }

    @RequestMapping("/ProductSearch.do")
    @ResponseBody
    public String getProductBySearch(String word) throws UnsupportedEncodingException {
        List<Product> products = productService.getProductBySearch(word);
        for(Product p:products){
            System.out.println(p);
        }
        return JSON.toJSONString(products);
    }



}
