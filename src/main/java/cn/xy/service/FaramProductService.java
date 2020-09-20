package cn.xy.service;

import cn.xy.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PackageName: cn.xy.service
 * @ClassName: FaramProductService.java
 * @Description: 产品操作业务接口
 * @Author: He_zhaofeng
 * @Data: 2020-09-16 22:38
 * @Version: V1.0.0
 **/
public interface FaramProductService {
        /**
         * @Description: 添加一个产品
         * @Params: [product]
         * @Returns: void
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-16 16:38
         **/
        int insertProduct(Product product);

        /**
         * @Description: 按名称模糊查询，返回所有包含关键字的Product实例
         * @Params: [productName]
         * @Returns: 返回所有包含关键字的Product实例列表
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-16 16:30
         **/
        Product nameFuzzyQuery(String productName);

        /**
         * @Description: 查询所有的审核通过商品
         * @Params: []
         * @Returns: cn.xy.bean.Product
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-17 10:26
         **/
        List<Product> findAll();


        /**
         * @Description: 根据产品id将产品下架，将pstate改为3，下架状态
         * @Params: [productId]
         * @Returns: void
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-16 16:34
         **/
        int updateProductState(@Param("id") Integer productId, @Param("time") String downtime);

        /**
         * @Description: 修改产品信息
         * @Params: [product]
         * @Returns: void
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-16 17:01
         **/
        int updProduct(Product product);


        /**
         * @Description: 根据产品id删除产品
         * @Params: [productId]
         * @Returns: void
         * @Throws:
         * @Author: He_zhaofeng
         * @Data: 2020-09-16 16:36
         **/
        int deleteProduct(Integer productId);

}
