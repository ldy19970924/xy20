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
        return userMapper.findUser(new User().setUstate(state));
    }

    /**
     * 通过id查询用户
     * @param uid
     * @return
     */
    @Override
    public List<User> findUserById(Integer uid) {
        return userMapper.findUser(new User().setUid(uid));
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

    @Override
    public User login(String uName, String password) {
        return userMapper.login(uName,password);
    }

    @Override
    public User loginByPhone(String phone, String code) {
        return userMapper.loginByPhone(phone,code);
    }

    @Override
    public int register(String uName, String password, String image, String phone,int state, String ucdCard) {
        int k=0;
        if(uName.equals("") || uName==null || password.equals("") || password == null){
            return k;
        }

        k=userMapper.register(new User().setUname(uName).setUcdcard(ucdCard).setPassword(password).setImage(image).setPhone(phone).setUstate(state));
        return k;
    }

    @Override
    public int registerByPhone(String uName,String password,String phone, int state, String ucdCard, String code) {
        int k = userMapper.registerByPhone(new User().setUname(phone).setPassword(password).setPhone(phone).setUstate(state).setUcdcard(ucdCard), code);
        return k;
    }
}
