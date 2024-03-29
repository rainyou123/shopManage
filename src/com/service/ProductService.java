package com.service;

import com.pojo.Category;
import com.pojo.Product;
import com.vo.PageBean;
import com.vo.QueryVo;

import java.util.List;

public interface ProductService {

    PageBean<Product> getAllProductByVo(QueryVo vo);

    int getCount();

    List<Product> getProductBySearch(String word);

    PageBean<Product> getProductListByWord(String pname);

}
