package cn.xy.servlet;

import cn.xy.bean.Product;
import cn.xy.service.ProductService;
import cn.xy.util.BaseServlet;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ProductServlet extends BaseServlet {
    @Resource
    private ProductService productService;

    protected String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null||name.equals("")){
            List<Product> productList = productService.findAll();
            Gson gson = new Gson();
            String json = gson.toJson(productList);
            resp.getWriter().write(json);
            req.setAttribute("productList",productList);
        }
        return "index.jsp";
    }

    protected String findByID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.findByID(Integer.parseInt(id));
        req.setAttribute("product",product);
        return "main.jsp";
    }
}
