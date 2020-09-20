package cn.xy.servlet;

import cn.xy.bean.User;
import cn.xy.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 通过手机号登录功能servlet
 * @Author  pzg
 *
 **/
@WebServlet("/LoginByPhoneServlet")
@Data
@Component
public class LoginByPhoneServlet extends HttpServlet {
    @Autowired
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("LOGIN-STATUS")==null){
            response.sendRedirect(request.getContextPath()+"/loginByPhone.jsp");
        }
        response.getWriter().println("Login success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.loginByPhone(request.getParameter("phone"), request.getParameter("code"));
            if(user != null){
                request.getSession().setAttribute("LOGIN-STATUS",user);
            }else {
                response.sendRedirect(request.getContextPath()+"/loginByPhone.jsp?error=loginFail");
            }
    }
}
