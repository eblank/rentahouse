package com.tenement.service.serviceImplements;

import com.tenement.mapper.HouseMapper;
import com.tenement.model.HouseExample;
import com.tenement.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LXPENG on 2016/5/5.
 */
@Service
public class HouseServiceImple implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 删除一条信息
     *
     * @param houseId
     * @return
     */
    @Override
    public boolean deleteOneHouseInfo(Long houseId) {
        int result = houseMapper.deleteByPrimaryKey(houseId);

        if (result > 0) {
            return true;
        }

        return false;
    }

    /**
     * 删除多条信息
     *
     * @param houseIdList
     * @return
     */
    @Override
    public boolean deleteHouseInfoList(List<Long> houseIdList) {
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andIdIn(houseIdList);
        int result = houseMapper.deleteByExample(houseExample);

        if (result > 0) {
            return true;
        }
        return false;
    }
}
