package com.dao;

import com.pojo.Category;
import com.pojo.Product;
import com.vo.Condition;

import java.util.List;

public interface ProductAdminDao {

    List<Product> getAllAdminProduct();

    List<Category> getCategoryList();

    List<Product> getProductByCondition(Condition condition);

    void addProduct(Product product);

    void deleteProductById(String pid);
}
