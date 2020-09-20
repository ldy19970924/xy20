package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @PackageName: cn.xy.bean
 * @ClassName: Faram.java
 * @Description: 一个农家乐实例类
 * @Author: He_zhaofeng
 * @Data: 2020-09-16 14:11
 * @Version: V1.0.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Faram {
    /*
     *农家乐编号
     */
    private Integer farmid;

    /*
     *农户编号
     */
    private Integer sid;

    /*
     *农家乐图片
     */
    private String farmimage;

    /*
     *农家乐地址
     */
    private String farmaddress;

    /*
     *农家乐电话
     */
    private String faramphone;

    /*
     *农家乐详情
     */
    private String faramdatil;
}
