package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Store {
    /**
     * 用户编号
     */
    private Integer storeid;
    /**
     * 用户账号
     */
    private String storeaccount;
    /**
     * 用户名
     */
    private String storename;
    /**
     * 用户密码
     */
    private String storepassword;
    /**
     * 头像
     */
    private String storeimage;
    /**
     * 电话
     */
    private String storephone;
    /**
     * 状态（0正常、1封禁、2申请解封、3申请解封中）
     */
    private Integer storestate;
    /**
     * 身份证
     */
    private String storecdcard;
    /**
     * 账号冻结时间
     */
    private String storefreezetime;
    /**
     * 账号解封时间
     */
    private String storeunlocktime;
    /**
     * 农户地址
     */
    private  String storeaddress;
}
