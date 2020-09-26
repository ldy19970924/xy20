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

}
