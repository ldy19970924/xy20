package cn.xy.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * product
 * @author 
 */
@Data
@Setter
@Accessors(chain = true)
public class Product implements Serializable {
    /**
     * 商品编号
     */
    private Integer productid;

    /**
     * 商品名称
     */
    private String productname;

    /**
     * 商品图片
     */
    private String productimage;

    /**
     * 上架时间
     */
    private String producttime;

    /**
     * 下架时间
     */
    private String downtime;

    /**
     * 库存
     */
    private Integer productcount;

    /**
     * 单价
     */
    private Double productprice;

    /**
     * 产地
     */
    private String origin;

    /**
     * 农户编号
     */
    private Integer storeid;

    /**
     * 商品审核状态（0未审核、1审核中、2审核通过）
     */
    private Integer productstate;

    /**
     * 文字描述
     */
    private String describe;

    /**
     * 商品类别编号
     */
    private Integer categoryid;

}