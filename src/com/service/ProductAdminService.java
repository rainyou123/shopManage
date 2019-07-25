package com.service;

import com.pojo.Category;
import com.pojo.Product;
import com.vo.Condition;
import com.vo.PageBean;
import com.vo.QueryVo;

import java.util.List;

public interface ProductAdminService {

    List<Product> getAllAdminProduct();

    List<Category> getCategoryList();

    List<Product> getProductByCondition(Condition condition);

    void addProduct(Product product);

    void deleteProductById(String pid);
}
