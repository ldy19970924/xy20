package cn.xy.mapper;

import cn.xy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李东盈
 */
@Repository("userMapper")
public interface UserMapper {
    /**
     * 查询用户
     */
    List<User> findUser(User user);
    /**
     * 修改用户状态
     */
    int updateUserState(User user);
    /**
     * @Description 登录方法,通过账号密码登录
     * @Param uName 用户名
     * @Param password 用户密码
     **/
    User login(@Param("uname") String uName,@Param("password") String password);

    /**
     * @Description 登录方法,通过手机号和验证码登录
     * @Param phone 用户手机号
     * @Param code  验证码
     **/
    User loginByPhone(String phone,String code);
    /**
     * @Description 注册方法,通过账号密码进行注册
     * @Param uId 用户id
     * @Param username 用户名
     * @Param password 用户密码
     * @Param image 用户头像
     * @Param phone 用户手机号
     * @Param ucdCard 用户身份证号
     * @Param state 用户状态
     * @Param freeZeTime 用户冻结时间
     * @Param unLockTime 用户解封时间
     **/
    int register(User user);
    /**
     * @Description 注册方法,通过手机号，获取验证码码验证注册
     * @Param uId 用户id
     * @Param username 用户名
     * @Param password 用户密码
     * @Param image 用户头像
     * @Param phone 用户手机号
     * @Param ucdCard 用户身份证号
     * @Param state 用户状态
     * @Param freeZeTime 用户冻结时间
     * @Param unLockTime 用户解封时间
     **/
    int registerByPhone(@Param("user") User user,@Param("code") String code);


}
