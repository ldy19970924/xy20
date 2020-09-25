package cn.xy.controller;

import cn.xy.bean.Store;
import cn.xy.service.StoreService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("store")
public class StoreServlet extends HttpServlet {
    @Resource(name = "storeServiceImpl")
    private StoreService storeService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        uri=uri.substring(req.getContextPath().length());
        switch (uri){

            case "/store/findStoreByState":findStoreByState(req, resp);break;
            case "/store/updateStoreState":updateStoreState(req, resp); break;
            default:findAllStore(req, resp); break;

        }
    }

    /**
     * 查询所有农户
     * @param req
     * @param resp
     */
    private void findAllStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Store> storeAllList = this.storeService.findAllStore();
        req.setAttribute("storeAllList",storeAllList);
        req.getRequestDispatcher("/store.jsp").forward(req, resp);
    }

    /**
     * 通过id修改农户状态
     * 只有0超级管理员和2拥有账号管理权限的管理员才能修改农户状态
     * @param req
     * @param resp
     */
    private void updateStoreState(HttpServletRequest req, HttpServletResponse resp) {
    }

    /**
     * 通过状态查询农户
     * @param req
     * @param resp
     */
    private void findStoreByState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String state = req.getParameter("state");
        List<Store> storeList = this.storeService.findStoreByState(Integer.valueOf(state));
        req.setAttribute("storeList",storeList);
        req.getRequestDispatcher("/store.jsp").forward(req, resp);
    }
}