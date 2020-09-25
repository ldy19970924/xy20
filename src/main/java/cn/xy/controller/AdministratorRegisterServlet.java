package cn.xy.controller;
import cn.xy.service.AdministratorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Description 通过账号密码注册管理员账号的servlet
 * @Author  pzg
 *
 **/
@Data
@Component
public class AdministratorRegisterServlet extends HttpServlet {
    @Autowired
    private AdministratorService administratorService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String aname = req.getParameter("aname");
        String apassword = req.getParameter("apassword");
        String phone =req.getParameter("phone");
        int right =5;
        int k = administratorService.register(aname,phone,apassword,right);
        if (k > 0) {
            req.getRequestDispatcher("/administrator/administratorLogin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/administrator/administratorRegister.jsp").forward(req, resp);
        }
    }
}
