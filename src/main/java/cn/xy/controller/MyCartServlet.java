package cn.xy.controller;

import cn.xy.bean.Cart;
import cn.xy.bean.CartItem;
import cn.xy.service.ProductService;
import cn.xy.util.BaseServlet;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyCartServlet extends BaseServlet {

    @Resource
    private ProductService productService;


    protected String addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
             cart = new Cart();
        }
        String id = req.getParameter("id");
        String count = req.getParameter("count");
        CartItem item = new CartItem();
        item.setProduct(productService.findByID(Integer.parseInt(id)));
        item.setCount(Integer.parseInt(count));
        cart.addCartItem(item);
        req.getSession().setAttribute("cart",cart);
        return "MyCart.jsp";
    }

    protected String removeItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        cart.removeCartItem(Integer.parseInt(id));
        req.getSession().setAttribute("cart",cart);
        return "MyCart.jsp";
    }

    protected String changeCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        String count = req.getParameter("count");
        cart.changeCount(Integer.parseInt(id),Integer.parseInt(count));
        req.getSession().setAttribute("cart",cart);
        return "MyCart.jsp";
    }

    protected String clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        return "MyCart.jsp";
    }
}
