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
public class Collect {
    /**
     * 收藏id
     */
    private Integer collectid;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 产品编号
     */
    private Integer productid;
}
