package cn.xy.mapper;

import cn.xy.bean.Administrator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员持久层
 * @author 李东盈
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
    int deleteAdministrator(@Param("adminids") Integer ...aids);

}
