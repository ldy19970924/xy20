package cn.xy.service.impl;

import cn.xy.bean.Administrator;
import cn.xy.bean.User;
import cn.xy.mapper.UserMapper;
import cn.xy.service.UserService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 李东盈
 */
@Setter
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAllUser() {
        return userMapper.findUser(null);
    }

    /**
     * 通过用户状态查询
     * @param state
     * @return
     */
    @Override
    public List<User> findUserByState(Integer state) {
        return userMapper.findUser(new User().setUserstate(state));
    }

    /**
     * 通过id查询用户
     * @param uid
     * @return
     */
    @Override
    public List<User> findUserById(Integer uid) {
        return userMapper.findUser(new User().setUserid(uid));
    }

    /**
     * 只有4超级管理员和2拥有账号管理权限的管理员才能修改用户状态
     * @param id
     * @param user
     */
    @Override
    public String updateUserStateById(Integer id, User user) {
        int num = userMapper.updateUserState(user);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

}
