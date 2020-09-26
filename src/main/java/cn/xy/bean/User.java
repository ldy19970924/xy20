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
    private Integer userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户账号
     */
    private String useraccount;
    /**
     * 用户密码
     */
    private String userpassword;
    /**
     * 头像
     */
    private String userimage;
    /**
     * 电话
     */
    private String userphone;
    /**
     * 状态（0正常、1封禁、2申请解封、3申请解封中）
     */
    private Integer userstate;
    /**
     * 身份证
     */
    private String usercdcard;
    /**
     * 账号冻结时间
     */
    private String userfreezetime;
    /**
     * 账号解封时间
     */
    private String userunlocktime;
}
