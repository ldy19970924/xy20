package cn.xy.servlet;

import cn.xy.bean.Administrator;
import cn.xy.service.AdministratorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description 登录servlet
 * @Author  pzg
 *
 **/
@Data
@Component
public class AdministratorLoginServlet extends HttpServlet {
    @Autowired
    private AdministratorService administratorService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        if(req.getSession().getAttribute("LOGIN-STATUS")==null){
            resp.sendRedirect(req.getContextPath()+"/administrator/administratorLogin.jsp");
        }
        resp.getWriter().println("Login success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Administrator administrator = administratorService.login(req.getParameter("aname"), req.getParameter("apassword"));
        if(administrator != null){
            req.getSession().setAttribute("LOGIN-STATUS",administrator);
            List<Administrator> admainlists = this.administratorService.findAllAdmain();
            System.out.println(admainlists);
            req.setAttribute("admainlists",admainlists);
            req.getRequestDispatcher("/administrator/index.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/administrator/administratorLogin.jsp?error=loginFail");
        }
    }
}
