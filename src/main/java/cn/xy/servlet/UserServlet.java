package cn.xy.servlet;

import cn.xy.bean.Administrator;
import cn.xy.bean.Complaint;
import cn.xy.bean.User;
import cn.xy.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserServlet extends HttpServlet {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    private Administrator admin;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        uri=uri.substring(req.getContextPath().length());
        admin = (Administrator) req.getSession().getAttribute("LOGIN-STATUS");
        switch (uri){
            case "/userInfo/findUserByState":findUserByState(req, resp);break;
            case "/userInfo/updateUserState":updateUserState(req, resp); break;
            default:findAllUser(req, resp); break;
        }
    }

    /**
     * 查询所有用户
     * @param req
     * @param resp
     */
    private void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUserList = this.userService.findAllUser();
        System.out.println(allUserList.toString());
        req.setAttribute("allUserList",allUserList);
        req.getRequestDispatcher("/administrator/user.jsp").forward(req, resp);
    }

    /**
     * 通过用户编号修改状态
     * @param req
     * @param resp
     */
    private void updateUserState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("get".equalsIgnoreCase(req.getMethod())){
            String  uid = req.getParameter("uid");
            //通过id查询管理员
            if (uid!=null && !uid.isEmpty()){
                List<User> users = this.userService.findUserById(Integer.valueOf(uid));
                req.setAttribute("user",users);
                req.getRequestDispatcher("/administrator/userstate.jsp").forward(req, resp);
            }else{
                resp.sendError(400,"非法参数");
            }
        }else {
            String uid = req.getParameter("uid");
            String state = req.getParameter("state");
            if (admin.getRight() == 4||admin.getRight()==2) {
                    List<User> users = this.userService.findUserById(Integer.valueOf(uid));
                for (User user: users) {
                    //正常状态账号封禁
                    if(user.getUstate()==0 && state.equals("禁用")){
                        Date date = new Date();
                        String format = DateFormat.getDateTimeInstance().format(date);
                        user.setFreezetime(format);
                        user.setUstate(1);
                        this.userService.updateUserStateById(Integer.valueOf(uid), user);
                        findAllUser(req, resp);
                    }
                    //封禁账号解封
                    if(user.getUstate()==2 && state.equals("启用")){
                        Date date = new Date();
                        String format = DateFormat.getDateTimeInstance().format(date);
                        user.setUnlocktime(format);
                        user.setUstate(0);
                        this.userService.updateUserStateById(Integer.valueOf(uid), user);
                        findAllUser(req, resp);
                }


                }


            }
            else {
                resp.getWriter().println("您没有此权限!");
            }
        }

    }

    /**
     * 根据账号状态查询用户信息
     * @param req
     * @param resp
     */
    private void findUserByState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String state = req.getParameter("state");
        List<User> userList = this.userService.findUserByState(Integer.valueOf(state));
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/admin/user.jsp").forward(req, resp);
    }

}
