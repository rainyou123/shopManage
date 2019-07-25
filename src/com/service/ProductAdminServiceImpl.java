package com.service;

import com.dao.ProductAdminDao;
import com.dao.ProductDao;
import com.pojo.Category;
import com.pojo.Product;
import com.vo.Condition;
import com.vo.PageBean;
import com.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAdminServiceImpl implements ProductAdminService {

    @Autowired
    private ProductAdminDao productAdminDao;

    @Override
    public List<Product> getAllAdminProduct() {
        return productAdminDao.getAllAdminProduct();
    }

    @Override
    public List<Category> getCategoryList() {
        return productAdminDao.getCategoryList();
    }

    @Override
    public List<Product> getProductByCondition(Condition condition) {
        return productAdminDao.getProductByCondition(condition);
    }

    @Override
    public void addProduct(Product product) {
        productAdminDao.addProduct(product);
    }

    @Override
    public void deleteProductById(String pid) {
        productAdminDao.deleteProductById(pid);
    }


}
