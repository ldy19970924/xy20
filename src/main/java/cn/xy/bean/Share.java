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
public class Share {
    /**
     * 分享编号
     */
    private Integer shareid;
    /**
     * 标题
     */
    private Integer title;
    /**
     * 分享图片
     */
    private Integer shareimage;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 分享时间
     */
    private String sharetime;
    /**
     * 文字描述
     */
    private String text;
}
