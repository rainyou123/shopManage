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
        PageBean<Product> pageBean =new PageBean<>();
        if(vo!=null){
            //每页最大数量
            vo.setMaxCount(12);
            String s=vo.getCurrentPage()+"";
            if(null != s && !s.equals("") && vo.getCurrentPage()!=0){
                pageBean.setCurrentPage(vo.getCurrentPage());
                //起始索引
                vo.setIndex((vo.getCurrentPage()-1)*vo.getMaxCount());
            }
            //符合条件的数据数量（其实就是产品数据总量）
            pageBean.setTotalCount(productDao.getCount());
            //总页数(查询出的数量/每页最大数量)
            int totalPages = (int)Math.ceil(1.0 * pageBean.getTotalCount() / vo.getMaxCount());
            pageBean.setTotalPages(totalPages);
            //每页的产品数据
            pageBean.setRows(productDao.getProductByLimit(vo));
            //每页容纳最大数量 ，其实不写也行 没用
            pageBean.setMaxCount(12);


//            if(null != vo.getPage() && !vo.getPage().equals("")){
//                page.setPage(Integer.valueOf(vo.getPage()));
//                vo.setStartIndex((Integer.valueOf(vo.getPage())-1)*vo.getMaxCount());
//            }
//            page.setSize(5);
//            page.setTotal(customerDao.getCustomerTotal(vo));
//            page.setRows(customerDao.getCustomerlist(vo));

        }else{
            vo.setMaxCount(12);
            vo.setCurrentPage(1);
            vo.setIndex((vo.getCurrentPage()-1)*vo.getMaxCount());
//            vo.setIndex((Integer.valueOf(vo.getCurrentPage())-1)*vo.getMaxCount());
            pageBean.setCurrentPage(1);
            pageBean.setTotalCount(productDao.getCount());
            int totalPages = (int)Math.ceil(1.0 * pageBean.getTotalCount() / vo.getMaxCount());
            pageBean.setTotalPages(totalPages);
            pageBean.setRows(productDao.getProductByLimit(vo));
            pageBean.setMaxCount(12);

        }
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
    public List<Product> getAllAdminProduct() {
        return productDao.getAllAdminProduct();
    }


}
