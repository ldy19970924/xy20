package cn.xy.service.impl;

import cn.xy.bean.Administrator;
import cn.xy.bean.Store;
import cn.xy.mapper.StoreMapper;
import cn.xy.service.StoreService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李东盈
 */
@Setter
@Service(value = "storeServiceImpl")
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMapper storeMapper;

    private Administrator administrator;
    /**
     * 查询所有农户
     * @return
     */
    @Override
    public List<Store> findAllStore() {
        return storeMapper.findStore(null);
    }

    /**
     * 通过用户状态查询农户
     * @param state
     * @return
     */
    @Override
    public List<Store> findStoreByState(Integer state) {
        return storeMapper.findStore(new Store().setStorestate(state));
    }

    /**
     * 只有4超级管理员和2拥有账号管理权限的管理员才能修改农户状态
     * @param id
     * @param state
     */
    @Override
    public String updateStoreStateById(Integer id, Integer state) {
            if (administrator.getRight()==0|| administrator.getRight()==2) {
                int num = storeMapper.updateStoreState(id, state);
                if (num > 0) {
                    return "修改成功";
                }
            }
        return "修改失败";
    }
}
