package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    /**
     * 用户编号
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 头像
     */
    private String image;
    /**
     * 电话
     */
    private String phone;
    /**
     * 状态（0正常、1封禁、2申请解封、3申请解封中）
     */
    private Integer ustate;
    /**
     * 身份证
     */
    private String ucdcard;
    /**
     * 账号冻结时间
     */
    private String freezetime;
    /**
     * 账号解封时间
     */
    private String unlocktime;
}
