package com.dao;

import com.pojo.Product;
import com.vo.QueryVo;

import java.util.List;

public interface ProductDao {

    int getCount();

    List<Product> getProductByLimit(QueryVo vo);

    List<Product> getProductBySearch(String word);


    List<Product> getAllAdminProduct();
}
