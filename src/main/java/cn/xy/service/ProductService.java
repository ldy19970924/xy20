package cn.xy.service;

import cn.xy.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    /**
     * 查询所有商品
     * @return
     */
    List<Product> findAll();

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product findByID(int id);

    /**
     * 根据id删除商品
     * @param id
     */
    void delByProductid(int id);

    /**
     * 根据id修改商品信息
     * @param id
     */
    void updateProductid(int id);

    /**
     * 添加商品
     * @param product
     */
    void insertBatch(Product product);
}
