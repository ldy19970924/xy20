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
    /**
     * @Description 登录方法,通过账号密码登录
     * @Param username 用户名
     * @Param password 用户密码
     **/
    Administrator login(String aName,String aPassword);

    /**
     * @Description 注册方法,通过账号密码进行注册
     * @Param aId 管理院id
     * @Param aName 用户名
     * @Param aPassword 用户密码
     *
     **/
    int register(String aName,String phone,String aPassword,int right);
}
