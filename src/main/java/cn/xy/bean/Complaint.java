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
    private Integer cid;
    private Integer uid;
    private String ctime;
    private Integer producted;
    private String content;
    /**
     * 0未处理
     * 1已处理
     */
    private Integer cstate;
    private String result;
}
