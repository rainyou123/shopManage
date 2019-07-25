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

    //分页显示全部商品
    @RequestMapping("/productList.do")
    public String getAllProductByLimit(HttpServletRequest req , Model model){
        String currentPage = req.getParameter("currentPage");
        QueryVo vo = new QueryVo();
        if(currentPage == null) currentPage = "1";
        System.out.println(currentPage);
        vo.setCurrentPage(Integer.valueOf(currentPage));
        PageBean<Product> pageBean = productService.getAllProductByVo(vo);
        model.addAttribute("pageBean" , pageBean);
        return "product_list";
    }

    //查询框的下边
    @RequestMapping("/ProductSearch.do")
    @ResponseBody
    public String getProductBySearch(String word) throws UnsupportedEncodingException {
        List<Product> products = productService.getProductBySearch(word);
        return JSON.toJSONString(products);
    }
    //根据输入查询文字 来显示商品
    @RequestMapping("/ProductSearchByWord.do")
    public String getProductListByWord(String pname,Model model){
        PageBean<Product> pageBean = productService.getProductListByWord(pname);
       model.addAttribute("pageBean" , pageBean);
        return "product_list";
    }



}
