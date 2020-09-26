package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Administrator {

    /**
     * 管理员编号
     */
    private Integer adminid;

    /**
     * 管理员账号
     */
    private String adminname;


    /**
     *管理员密码
     */
    private String adminpassword;

    /**
     *管理员权限（4超级管理员、1处理投诉、2账号管理、3审核商品权限、5通用权限）
     */
    private Integer right;

}
