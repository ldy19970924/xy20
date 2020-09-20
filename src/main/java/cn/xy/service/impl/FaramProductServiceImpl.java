package cn.xy.service.impl;

import cn.xy.bean.Product;
import cn.xy.mapper.FaramProductMapper;
import cn.xy.service.FaramProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FaramProductServiceImpl implements FaramProductService {
    @Resource
    private FaramProductMapper faramProductMapper;

    @Override
    public int insertProduct(Product product) {

        return faramProductMapper.insertProduct(product);
    }

    @Override
    public Product nameFuzzyQuery(String productName) {
        return faramProductMapper.nameFuzzyQuery(productName);
    }

    @Override
    public List<Product> findAll() {
        return faramProductMapper.findAll();
    }

    @Override
    public int updateProductState(Integer productId, String downtime) {
        return faramProductMapper.updateProductState(productId,downtime);
    }

    @Override
    public int updProduct(Product product) {
        return faramProductMapper.updProduct(product);
    }

    @Override
    public int deleteProduct(Integer productId) {
        return faramProductMapper.deleteProduct(productId);
    }
    
}
