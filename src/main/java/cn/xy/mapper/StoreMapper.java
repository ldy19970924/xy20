package cn.xy.mapper;

import cn.xy.bean.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
/**
 * @author 李东盈
 */
@Repository(value = "storeMapper")
public interface StoreMapper {
    /**
     * 查询农户
     */
    List<Store> findStore(Store store);
    /**
     * 修改农户状态
     */

    int updateStoreState(@Param("sid") Integer sid,@Param("state") Integer state);

}
