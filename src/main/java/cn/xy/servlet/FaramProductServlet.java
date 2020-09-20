package cn.xy.servlet;

import cn.xy.bean.Product;
import cn.xy.service.FaramProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName: cn.xy.servlet
 * @ClassName: FaramProductServlet.java
 * @Description: 农户Servlet
 * @Author: He_zhaofeng
 * @Data: 2020-09-17 11:00
 * @Version: V1.0.0
 **/

@Component
public class FaramProductServlet extends HttpServlet {

    @Autowired
    private FaramProductService faramProductService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        uri = uri.substring(req.getContextPath().length());
        switch (uri){
            case "/faramproduct/add":
                add(req,resp);
                break;
            case "/faramproduct/del":
                del(req,resp);
                break;
            case "/faramproduct/findbyname":
                findbyname(req,resp);
                break;
            case "/faramproduct/updatestate":
                updatestate(req,resp);
                break;
            case "/faramproduct/updateproduct":
                updateproduct(req,resp);
                break;
            default:
                findAll(req,resp);



        }
    }

    /**
     *@Description: 查询所有上架商品
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(new Gson().toJson(faramProductService.findAll()));

    }

    /**
     *@Description: 修改商品
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void updateproduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     *@Description: 下架商品
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void updatestate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     *@Description: 查询商品，模糊搜索
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void findbyname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     *@Description: 删除商品
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        int num = this.faramProductService.deleteProduct(Integer.valueOf(productId));
        if (num > 0){
            resp.getWriter().write("删除成功");
        }else{
            resp.getWriter().write("删除失败");
        }




    }

    /**
     *@Description: 添加商品
     *@Params: [req, resp]
     *@Returns: void
     *@Throws:
     *@Author: He_zhaofeng
     *@Data: 2020-09-17 11:24
     **/
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateNowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Product insertProduct = new Product().setProductname(req.getParameter("productName"))
                .setProductimage(req.getParameter("productImage"))
                .setProducttime(dateNowStr)
                .setProductcount(Integer.valueOf(req.getParameter("productCount")))
                .setProductprice(Double.valueOf(req.getParameter("productPrice")))
                .setOrigin(req.getParameter("origin"))
                .setSid(1)
                .setPstate(2)
                .setDescribe(req.getParameter("describe"))
                .setCateid(2);
        System.out.println(insertProduct.toString());
        faramProductService.insertProduct(insertProduct);
    }
}