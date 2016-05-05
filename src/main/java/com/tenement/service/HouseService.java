package com.tenement.service;

import java.util.List;

/**
 * Created by LXPENG on 2016/5/5.
 *
 */
public interface HouseService {
    /**
     * 删除多条信息
     *
     * @param houseIdList
     * @return
     */
    boolean deleteHouseInfoList(List<Long> houseIdList);

    /**
     * 删除一条信息
     *
     * @param houseId
     * @return
     */
    boolean deleteOneHouseInfo(Long houseId);
}
