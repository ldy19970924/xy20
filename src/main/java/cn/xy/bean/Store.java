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
    private Integer sid;
    /**
     * 用户名
     */
    private String sname;
    /**
     * 用户密码
     */
    private String spassword;
    /**
     * 头像
     */
    private String simage;
    /**
     * 电话
     */
    private String sphone;
    /**
     * 状态（0正常、1封禁、2申请解封、3申请解封中）
     */
    private Integer state;
    /**
     * 身份证
     */
    private String cdcard;
    /**
     * 账号冻结时间
     */
    private String sfreezetime;
    /**
     * 账号解封时间
     */
    private String sunlocktime;
}
