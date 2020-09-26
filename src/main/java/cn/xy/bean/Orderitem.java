package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Orderitem {
    /**
     * 条目编号
     */
    private Integer itemid;
    /**
     * 产品编号
     */
    private Integer productid;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 商品小计
     */
    private Double subtotal;
}
