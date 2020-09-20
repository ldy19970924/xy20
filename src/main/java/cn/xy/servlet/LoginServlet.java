package cn.xy.servlet;

import cn.xy.bean.User;
import cn.xy.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 登录servlet
 * @Author  pzg
 *
 **/
@Data
@Component
public class LoginServlet extends HttpServlet {
    @Autowired
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("LOGIN-STATUS")==null){
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
        resp.getWriter().println("Login success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.login(req.getParameter("uName"), req.getParameter("password"));
        if(user != null){
            req.getSession().setAttribute("LOGIN-STATUS",user);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");

        }else {
            resp.sendRedirect(req.getContextPath()+"/login.jsp?error=loginFail");
        }
    }
}
