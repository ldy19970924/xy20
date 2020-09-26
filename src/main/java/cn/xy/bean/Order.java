package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    /**
     * 订单编号
     */
    private Integer orderid;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 收件人电话
     */
    private String phone;
    /**
     * 下单时间
     */
    private String ordertime;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 条目编号
     */
    private Integer itemid;
    /**
     * 订单总价
     */
    private Double price;
    /**
     * 支付宝交易号
     */
    private Integer alipay;
    /**
     * 运单号
     */
    private Integer waybill;
    /**
     *
     * 订单状态
     */
    private Integer orderstate;
}
