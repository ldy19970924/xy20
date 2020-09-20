package cn.xy.service.impl;

import cn.xy.bean.Product;
import cn.xy.mapper.ProductMapper;
import cn.xy.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findByID(int id) {
        return productMapper.findByID(id);
    }

    @Override
    public void delByProductid(int id) {
        delByProductid(id);

    }

    @Override
    public void updateProductid(int id) {
        updateProductid(id);
    }

    @Override
    public void insertBatch(Product product) {
        productMapper.insertBatch(product);
    }
}
