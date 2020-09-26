package cn.xy.controller;

import cn.xy.bean.Administrator;
import cn.xy.service.AdministratorService;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 李东盈
 */
@Data
@Controller
public class AdministratorServlet extends HttpServlet {
    @Resource
    private AdministratorService administratorService;

    private Administrator admin;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取管理员登录账号
        admin = (Administrator) req.getSession().getAttribute("LOGIN-STATUS");

        String uri = req.getRequestURI();
        uri=uri.substring(req.getContextPath().length());
        switch (uri){
            case "/admin/updateRight":updateRight(req, resp);break;
            case "/admin/insertAdmains":insertAdmains(req, resp); break;
            case "/admin/deleteAdmins":deleteAdmins(req, resp);break;
            default:findAdmins(req, resp); break;

        }
    }
    /**
     * 删除管理员
     * 管理员状态为0超级管理员通过id批量删除管理员的权限
     * @param req
     * @param resp
     */
    private void deleteAdmins(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] aidsStr = req.getParameterValues("id");
        Integer[] aids = new Integer[aidsStr.length];
        for (int i = 0; i < aidsStr.length; i++) {
            aids[i] = Integer.valueOf(aidsStr[i]);
            aids[i].toString();
        }
            if(admin.getRight()==4) {
                this.administratorService.deleteAdmin(aids);
                resp.sendRedirect(req.getContextPath()+"/admin");
            }

        resp.getWriter().println("对不起您没有此权限");
    }

    /**
     * 添加管理员
     * 管理员状态为4超级管理员或者拥有2账号管理权限的管理员账号才拥有添加管理员的权限
     * @param req
     * @param resp
     */
    private void insertAdmains(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (admin.getRight() == 4||admin.getRight() == 2) {
            this.administratorService.save(parseAdmins(req));
            findAdmins(req, resp);
        }
        else {
            resp.getWriter().println("您没有此权限!");
        }
    }


    /**
     * 修改管理员权限
     * 有状态为0的超级管理员才能通过管理员编号修改管理员权限
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateRight(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        if ("get".equalsIgnoreCase(req.getMethod())){
            String  aid = req.getParameter("aid");
        //通过id查询管理员
        if (aid!=null && !aid.isEmpty()){
            List<Administrator> administrator = this.administratorService.findAdmainById(Integer.valueOf(aid));
            req.setAttribute("administrator",administrator);
            req.getRequestDispatcher("/administrator/pro_add.jsp").forward(req, resp);
        }else{
            resp.sendError(400,"非法参数");
        }
        }else {
            String  aid = req.getParameter("aid");
            if (admin.getRight() == 4||admin.getRight()==2) {
                List<Administrator> ad = this.administratorService.findAdmainById(Integer.valueOf(aid));
                if (((Administrator)ad).getRight()!=4){
                    this.administratorService.save(parseAdmins(req));
                }
                else {
                    resp.getWriter().println("您不能修改超级管理员的权限!");
                }
                findAdmins(req, resp);
            }
            else {
                resp.getWriter().println("您没有此权限!");
            }
        }
    }
    /**
     * 查询所有管理员
     */
    private void findAdmins(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        List<Administrator> admainlists = this.administratorService.findAllAdmain();
        req.setAttribute("admainlists",admainlists);
         req.getRequestDispatcher("/administrator/admingroup.jsp").forward(req, resp);
    }

    private Administrator parseAdmins(HttpServletRequest req){
        String aid = req.getParameter("aid");
        String aname = req.getParameter("aname");
        String apassword = req.getParameter("apassword");
        String right = req.getParameter("community_id");
        Administrator administrator = new Administrator();
        if (aid!=null && !aid.isEmpty()){
            administrator.setAdminid(Integer.valueOf(aid));
        }

        if (aname!=null && !aname.isEmpty()){
            administrator.setAdminname(aname);
        }

        if (apassword!=null && !apassword.isEmpty()){
            administrator.setAdminpassword(apassword);
        }
        if (right!=null && !right.isEmpty()){
            administrator.setRight(Integer.valueOf(right));

        }
        return administrator;
    }
}
