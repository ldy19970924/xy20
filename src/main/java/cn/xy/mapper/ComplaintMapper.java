package cn.xy.mapper;

import cn.xy.bean.Complaint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 投诉
 * @author 李东盈
 */
@Repository(value = "complaintMapper")
public interface ComplaintMapper {
    /**
     * 查询投诉
     */
    List<Complaint> findComplaint(Complaint complaint);
    /**
     * 修改投诉结果
     */
    int updateResult(@Param("complaintid")Integer cid, @Param("result") String result);

    /**
     * 修改投诉状态
     * @param cid
     * @param cstate
     * @return
     */
    int updateComplaintState(@Param("complaintid")Integer cid, @Param("complaintstate") Integer cstate);
    /**
     * 批量删除投诉
     */
    int deleteComplaint(@Param("complaintids") Integer ...cids);
}
