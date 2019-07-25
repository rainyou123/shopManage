package com.controller;

import com.pojo.Category;
import com.pojo.Product;
import com.service.ProductAdminService;
import com.service.ProductService;
import com.vo.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductAdminController {
    @Autowired
    private ProductAdminService productAdminService;

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
        List<Product> productList = productAdminService.getAllAdminProduct();
        model.addAttribute("productList" , productList);
        List<Category> categoryList = productAdminService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/list";
    }

    //按照条件查询
    @RequestMapping("/conditionSelect.do")
    public String getProductByCondition(Condition condition , Model model){
        List<Product> productList =productAdminService.getProductByCondition(condition);
        model.addAttribute("productList" , productList);
        List<Category> categoryList = productAdminService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/list";
    }

    //进入添加页面
    @RequestMapping("/addProduct.do")
    public String addProductCategory(Model model){
        List<Category> categoryList = productAdminService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/add";
    }
    //进行添加操作
    @RequestMapping("/adminProductAdd.do")
    public String addProduct(Product product,Model model){
        productAdminService.addProduct(product);
        List<Product> productList = productAdminService.getAllAdminProduct();
        model.addAttribute("productList" , productList);
        List<Category> categoryList = productAdminService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/list";
    }
    //进行删除操作
    @RequestMapping("/adminDeleteProduct.do")
    public String deleteProduct(String pid , Model model){
        productAdminService.deleteProductById(pid);
        List<Product> productList = productAdminService.getAllAdminProduct();
        model.addAttribute("productList" , productList);
        List<Category> categoryList = productAdminService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/list";
    }
}
