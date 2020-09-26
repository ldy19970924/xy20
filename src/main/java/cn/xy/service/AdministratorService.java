package cn.xy.service;

import cn.xy.bean.Administrator;

import java.util.List;

public interface AdministratorService {

    /**
     * 通过id批量删除管理员
     */
    String deleteAdmin(Integer ...aids);
    /**
     * 查询所有管理员
     */
    List<Administrator> findAllAdmain();
    /**
     *通过id查询管理员
     */
    List<Administrator> findAdmainById(Integer aid);

    /**
     * 保存
     * @param administrator
     */
    void save(Administrator administrator);

}
