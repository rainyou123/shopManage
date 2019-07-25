package com.service;



import com.dao.ProductDao;
import com.pojo.Product;
import com.vo.PageBean;
import com.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public PageBean<Product> getAllProductByVo(QueryVo vo) {
        PageBean<Product> pageBean = new PageBean<>();
        //每页最大数量
        vo.setMaxCount(12);
        pageBean.setCurrentPage(vo.getCurrentPage());
        //起始索引
        vo.setIndex((vo.getCurrentPage() - 1) * vo.getMaxCount());
        //符合条件的数据数量（其实就是产品数据总量）
        pageBean.setTotalCount(productDao.getCount());
        //总页数(查询出的数量/每页最大数量)
        int totalPages = (int) Math.ceil(1.0 * pageBean.getTotalCount() / vo.getMaxCount());
        pageBean.setTotalPages(totalPages);
        //每页的产品数据
        pageBean.setRows(productDao.getProductByLimit(vo));
        //每页容纳最大数量 ，其实不写也行 没用
        pageBean.setMaxCount(12);
        return pageBean;
    }

    @Override
    public int getCount() {
        return productDao.getCount();
    }

    @Override
    public List<Product> getProductBySearch(String word) {
        return productDao.getProductBySearch(word);
    }

    @Override
    public PageBean<Product> getProductListByWord(String pname) {
        PageBean<Product> pageBean = new PageBean<>();
        pageBean.setMaxCount(12);
        pageBean.setCurrentPage(1);
        //起始索引

        return pageBean;
    }


}
