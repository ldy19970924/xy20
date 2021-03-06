package cn.xy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Complaint {
    private Integer complaintid;
    private Integer userid;
    private String complainttime;
    private Integer productid;
    private String content;
    /**
     * 0未处理
     * 1已处理
     */
    private Integer complaintstate;
    private String result;
}
