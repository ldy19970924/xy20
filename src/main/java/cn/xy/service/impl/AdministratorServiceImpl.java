package cn.xy.service.impl;

import cn.xy.bean.Administrator;
import cn.xy.mapper.AdministratorMapper;
import cn.xy.service.AdministratorService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李东盈
 */
@Slf4j
@Data
@Service(value ="administratorServiceImpl")
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;

    /**
     * 管理员状态为4超级管理员或者有2账号管理权限的管理员账号才拥通过id批量删除管理员的权限
     */
    @Override
    public String deleteAdmin(Integer ...aids) {
        int num = administratorMapper.deleteAdministrator(aids);
            if (num > 0) {
                return "删除成功！";
            }
        return "删除失败！";
    }

    /**
     * 查询所有管理员
     * @return
     */
    @Override
    public List<Administrator> findAllAdmain() {
        List<Administrator> list = administratorMapper.findAdministrator(null);
        return list;
    }

    /**
     * 通过id查询管理员
     * @param aid
     * @return
     */
    @Override
    public List<Administrator> findAdmainById(Integer aid) {
        List<Administrator> list = administratorMapper.findAdministrator(new Administrator().setAdminid(aid));
        return list;
    }

    /**
     *
     * @param administrator
     */
    @Override
    public void save(Administrator administrator) {
        administratorMapper.save(administrator);
    }


}
