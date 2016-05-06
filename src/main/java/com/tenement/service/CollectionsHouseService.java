package com.tenement.service;

import java.util.List;

/**
 * Created by LXPENG on 2016/5/5.
 * 收藏信息服务
 */
public interface CollectionsHouseService {
    /**
     * 获取个人收藏信息
     *
     * @param userId
     * @param location
     * @param price
     * @param roomNumber
     * @param rentType
     * @param toward
     * @param decoration
     * @return
     */
    List getUserHouseList(String userId, String location, String price, String roomNumber, String rentType, String toward, String decoration);

    /**
     * 收藏一条信息
     *
     * @param userId
     * @param houseId
     * @return
     */
    boolean collectHouse(Long userId, Long houseId) throws Exception;

    /**
     * 收藏多条信息
     *
     * @param userId
     * @param houseIdList
     * @return
     */
    boolean collectHouseList(Long userId, List<Long> houseIdList) throws Exception;

    /**
     * 删除收藏信息
     *
     * @param userId
     * @param collectionIdList
     * @return
     */
    boolean cancelCollect(Long userId, List<Long> collectionIdList) throws Exception;

    /**
     * 保存备注信息
     *
     * @param userHouseId
     * @param remark
     * @return
     */
    boolean remarkHouseInfo(Long userHouseId, String remark);

    /**
     * 获取收藏信息备注
     *
     * @param userHouseId
     * @return
     */
    String getCollectionRemark(Long userHouseId) throws Exception;

}
