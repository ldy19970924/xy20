package cn.xy.controller;

import cn.xy.bean.Administrator;
import cn.xy.bean.Complaint;
import cn.xy.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("complaint")
public class ComplaintServlet extends HttpServlet {
    @Autowired
    private ComplaintService complaintService;

    private Administrator admin;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        uri=uri.substring(req.getContextPath().length());
        admin = (Administrator) req.getSession().getAttribute("LOGIN-STATUS");
        switch (uri){
            case "/complaint/findIsResult":findIsResult(req, resp);break;
            case "/complaint/findNoResult":findNoResult(req, resp); break;
            case "/complaint/updateComplaint":updateComplaint(req, resp); break;
            case "/complaint/delectComplaint":delectComplaint(req, resp); break;
            default:findAllComplaint(req, resp); break;

        }
    }

    /**
     * 登录账号权限为1
     * 删除已处理的评论
     * @param req
     * @param resp
     */
    private void delectComplaint(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] cidsStr = req.getParameterValues("id");
        Integer[] cids = new Integer[cidsStr.length];
        for (int i = 0; i < cidsStr.length; i++) {
            cids[i] = Integer.valueOf(cidsStr[i]);
            cids[i].toString();
        }
        if(admin.getRight()==4||admin.getRight()==1) {
            this.complaintService.deleteComplaint(cids);
            resp.sendRedirect(req.getContextPath()+"/complaint");
        }

        resp.getWriter().println("对不起您没有此权限");
    }

    /**
     * 查询所有投诉
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findAllComplaint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<Complaint> allComplaint = this.complaintService.findAllComplaint();
        System.out.println(allComplaint.toString());
      req.setAttribute("allComplaint",allComplaint);
      req.getRequestDispatcher("/administrator/complaint.jsp").forward(req, resp);
    }

    /**
     * 处理投诉
     * 只有状态为0的超级管理员或状态为1的管理员才能通过管理员编号修改管理员权限
     * @param req
     * @param resp
     */
    private void updateComplaint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("get".equalsIgnoreCase(req.getMethod())){
            String  cid = req.getParameter("cid");
            //通过id查询管理员
            if (cid!=null && !cid.isEmpty()){
                List<Complaint> complaint = this.complaintService.findComplaintById(Integer.valueOf(cid));
                req.setAttribute("complaint",complaint);
                req.getRequestDispatcher("/administrator/complaintresult.jsp").forward(req, resp);
            }else{
                resp.sendError(400,"非法参数");
            }
        }else {
            String  cid = req.getParameter("cid");
            String result = req.getParameter("result");
            if (admin.getRight() == 4||admin.getRight()==1) {

                this.complaintService.updateComplaint(Integer.valueOf(cid), result);
                List<Complaint> com = this.complaintService.findComplaintById(Integer.valueOf(cid));
                String res=null;
                Integer ci = null;
                for (Complaint list: com) {
                     res = list.getResult();
                     ci=list.getComplaintid();
                }
                //处理结果不为空则修改处理状态
                if (!res.isEmpty()) {
                    //状态为1，已处理
                   this.complaintService.updateComplaintState(ci, 1);
                    findAllComplaint(req, resp);
                }else {
                    resp.getWriter().println("投诉处理出现异常");
                }

            }
            else {
                resp.getWriter().println("您没有此权限!");
            }
        }

    }

    /**
     * 查询未处理的投诉
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findNoResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Complaint> noResult = complaintService.findNoResult();
        req.setAttribute("noResult",noResult);
        req.getRequestDispatcher("/complaint.jsp").forward(req, resp);
    }

    /**
     * 查询已处理的投诉
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findIsResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Complaint> isResult = this.complaintService.findIsResult();
        req.setAttribute("isResult",isResult);
        req.getRequestDispatcher("/complaint.jsp").forward(req, resp);
    }
    private Complaint parseComplaint(HttpServletRequest req){
        String cid = req.getParameter("cid");
        String uid = req.getParameter("uid");
        String ctime = req.getParameter("ctime");
        String pruducted = req.getParameter("pruducted");
        String content = req.getParameter("content");
        String cstate = req.getParameter("cstate");
        String result = req.getParameter("result");
        Complaint complaint = new Complaint();
        if (cid!=null && !cid.isEmpty()){
            complaint.setComplaintid(Integer.valueOf(cid));
        }

        if (uid!=null && !uid.isEmpty()){
            complaint.setUserid(Integer.valueOf(uid));
        }
        if (ctime!=null && !ctime.isEmpty()){
            complaint.setComplainttime(ctime);
        }
        if (pruducted!=null && !pruducted.isEmpty()){
            complaint.setProductid(Integer.valueOf(pruducted));
        }
        if (content!=null && !content.isEmpty()){
            complaint.setContent(content);

        }
        if (cstate!=null && !cstate.isEmpty()){
            complaint.setComplaintstate(Integer.valueOf(cstate));
        }
        if (result!=null && !result.isEmpty()){
            complaint.setResult(result);
        }
        return complaint;
    }
}
