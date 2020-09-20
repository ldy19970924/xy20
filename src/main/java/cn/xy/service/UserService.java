package cn.xy.service;

import cn.xy.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     */
    List<User> findAllUser();
    /**
     * 根据账号状态查询用户信息
     */
    List<User> findUserByState(Integer state);

    /**
     * 通过id查询用户
     * @param uid
     * @return
     */
    List<User> findUserById(Integer uid);
    /**
     * 通过用户编号修改状态
     */
    String updateUserStateById(Integer id,User user);
    /**
     * @Description 登录方法,通过账号密码登录
     * @Param username 用户名
     * @Param password 用户密码
     **/
    User login(String uName, String password);

    /**
     * @Description 登录方法,通过手机号和验证码登录
     * @Param phone 用户手机号
     * @Param code  验证码
     **/
    User loginByPhone(String phone,String code);
    /**
     * @Description 注册方法,通过账号密码进行注册
     * @Param username 用户名
     * @Param password 用户密码
     * @Param image 用户头像
     * @Param phone 用户手机号
     * @Param ucdCard 用户身份证
     **/
    int register(String uName, String password, String image, String phone,int state, String ucdCard);
    /**
     * @Description 注册方法,通过账号密码进行注册
     * @Param username 用户名
     * @Param password 用户密码
     * @Param image 用户头像
     * @Param phone 用户手机号
     * @Param ucdCard 用户身份证
     **/
    int registerByPhone(String uName,String password,String phone,int state, String ucdCard,String code);

}
