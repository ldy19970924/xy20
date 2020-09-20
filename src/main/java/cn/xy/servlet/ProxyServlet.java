package cn.xy.servlet;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class ProxyServlet extends HttpServlet {

    private Servlet servlet;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        servlet.service(req, res);
    }

    @Override
    public void destroy() {
        servlet.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String name = config.getServletName();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        this.servlet=applicationContext.getBean(name,Servlet.class);
        this.servlet.init(config);
    }
}
