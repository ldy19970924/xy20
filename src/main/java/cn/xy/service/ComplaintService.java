package cn.xy.service;

import cn.xy.bean.Complaint;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理投诉
 * @author 李东盈
 */
@Repository
public interface ComplaintService {
    /**
     *  通过id修改投诉状态
     * @param id
     * @param state
     * @return
     */
    String updateComplaintState(Integer id,Integer state);
    /**
     * 通过id修改投诉信息
     */
    String updateComplaint(Integer id,String result);
    /**
     * 查询所有投诉信息
     */
    List<Complaint> findAllComplaint();
    /**
     * 查询所有已处理投诉信息
     */
    List<Complaint> findIsResult();
    /**
     * 查询所有未处理投诉信息
     */
    List<Complaint> findNoResult();

    /**
     * 通过id查询投诉
     * @param cid
     * @return
     */
    List<Complaint> findComplaintById(Integer cid);
    /**
     * 批量删除投诉
     * @param cids
     * @return
     */
    String deleteComplaint(Integer ...cids);
    /**
     * 查询农户的投诉
     */
    /**
     * 查询用户的投诉
     */
}
