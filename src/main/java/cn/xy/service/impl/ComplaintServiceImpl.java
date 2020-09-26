package cn.xy.service.impl;

import cn.xy.bean.Complaint;
import cn.xy.mapper.ComplaintMapper;
import cn.xy.service.ComplaintService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李东盈
 */
@Data
@Service(value = "complaintServiceImpl")
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintMapper complaintMapper;

    /**
     * 修改投诉状态
     * @param id
     * @param state
     * @return
     */
    @Override
    public String updateComplaintState(Integer id, Integer state) {
        int num = complaintMapper.updateComplaintState(id, state);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    /**
     * 只有4超级管理员或者拥有1.处理投诉权限的管理员才能通过id修改投诉信息
     * @param id
     * @param result
     * @return
     */
    @Override
    public String updateComplaint(Integer id, String result) {
        int num = complaintMapper.updateResult(id, result);
                if (num > 0) {
                    return "修改成功";
                }
        return "修改失败";
    }
    /**
     * 查询所有投诉信息
     * @return
     */
    @Override
    public List<Complaint> findAllComplaint() {
        List<Complaint> list =complaintMapper.findComplaint(null);
        return list;
    }

    /**
     * 查询所有已处理投诉信息
     * @return
     */
    @Override
    public List<Complaint> findIsResult() {
        return complaintMapper.findComplaint(new Complaint().setComplaintstate(1));
    }

    /**
     * 查询所有未处理投诉信息
     * @return
     */
    @Override
    public List<Complaint> findNoResult() {
        return complaintMapper.findComplaint(new Complaint().setComplaintstate(0));
    }

    /**
     *
     * @param cid
     * @return
     */
    @Override
    public List<Complaint> findComplaintById(Integer cid) {
        List<Complaint> list = complaintMapper.findComplaint(new Complaint().setComplaintid(cid));
        return list;
    }

    /**
     * 批量删除投诉
     * @param cids
     * @return
     */
    @Override
    public String deleteComplaint(Integer... cids) {
        int num = complaintMapper.deleteComplaint(cids);
        if (num > 0) {
            return "删除成功！";
        }
        return "删除失败！";
    }

}
