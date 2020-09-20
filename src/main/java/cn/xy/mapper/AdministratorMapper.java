package cn.xy.mapper;

import cn.xy.bean.Administrator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员持久层
 *
 */

@Repository(value = "administratorMapper")
public interface AdministratorMapper {
    /**
     * 保存管理员
     * @param administrator
     */
    void save(Administrator administrator);

    /**
     * 查询管理员
     */
    List<Administrator> findAdministrator(Administrator administrator);
    /**
     * 批量删除管理员
     */
    int deleteAdministrator(@Param("aids") Integer ...aids);
    /**
     * @Description 登录方法,通过账号密码登录
     * @Param username 用户名
     * @Param password 用户密码
     **/
    Administrator login(@Param("aname") String aName, @Param("apassword") String aPassword);

    /**
     * @Description 注册方法,通过账号密码进行注册
     * @Param aName 用户名
     * @Param aPassword 用户密码
     **/
    int register(Administrator administrator);
}
