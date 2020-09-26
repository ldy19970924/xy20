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

}
