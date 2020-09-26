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
public class Evaluate {
    /**
     * 评价编号
     */
    private Integer evaluateid;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 产品编号
     */
    private Integer productid;
    /**
     * 文本内容
     */
    private String textcontent;
    /**
     * 图片
     */
    private String image;
    /**
     * 评价时间
     */
    private String evaluatetime;
    /**
     * 分享编号
     */
    private Integer shareid;
}
