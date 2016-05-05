package com.tenement.service.serviceImplements;

import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.HouseMapper;
import com.tenement.mapper.UserHouseMapper;
import com.tenement.mapper.UserMapper;
import com.tenement.model.*;
import com.tenement.model.constant.QueryDecorationEnum;
import com.tenement.model.constant.QueryRoomNumberEnum;
import com.tenement.model.constant.QueryTowardEnum;
import com.tenement.service.CollectionsHouseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXPENG on 2016/5/5.
 */
@Service
public class CollectionsHouseServiceImpl implements CollectionsHouseService {
    @Autowired
    private UserHouseMapper userHouseMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private UserMapper userMapper;
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
    @Override
    public List getUserHouseList(String userId, String location, String price, String roomNumber, String rentType, String toward, String decoration) {
        UserHouseExample userHouseExample = new UserHouseExample();
        UserHouseExample.Criteria criteria = userHouseExample.createCriteria();
        criteria.andUserIdEqualTo(Long.parseLong(userId));

        //查询user关联房屋信息id列表
        List<UserHouse> userHouseList = userHouseMapper.selectByExample(userHouseExample);
        List<Long> houseIdList = new ArrayList<Long>();
        for (UserHouse userHouse : userHouseList) {
            houseIdList.add(userHouse.getHouseId());
        }

        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria houseCriteria = houseExample.createCriteria();

        if (StringUtils.isNotBlank(location)) {
            houseCriteria.andTownEqualTo(location);
        }
        if (StringUtils.isNotBlank(roomNumber)) {
            int bedroomNumber = QueryRoomNumberEnum.valueOf(roomNumber).getValue();
            if (bedroomNumber >= 5) {
                houseCriteria.andBedRoomGreaterThanOrEqualTo(bedroomNumber);
            } else {
                houseCriteria.andBedRoomEqualTo(bedroomNumber);
            }
        }
        if (StringUtils.isNotBlank(price)) {
            int minPrice = Integer.parseInt(price.split("_")[0]);
            String maxPriceString = price.split("_")[1];
            if ("*".equals(maxPriceString)) {
                houseCriteria.andHousePriceGreaterThan(minPrice);
            } else {
                houseCriteria.andHousePriceBetween(minPrice, Integer.parseInt(maxPriceString));
            }
        }
        if (StringUtils.isNotBlank(toward)) {
            toward = QueryTowardEnum.valueOf(toward).getValue();
            houseCriteria.andTowardEqualTo(toward);
        }
        if (StringUtils.isNotBlank(decoration)) {
            decoration = QueryDecorationEnum.valueOf(decoration).getValue();
            houseCriteria.andDecorationEqualTo(decoration);
        }
        if (StringUtils.isNotBlank(rentType)) {

        }
        houseCriteria.andIdIn(houseIdList);

        List<House> houseList = houseMapper.selectByExample(houseExample);
        return houseList;
    }

    /**
     * 收藏信息
     *
     * @param userId
     * @param houseId
     * @return
     */
    @Override
    public boolean collectHouse(Long userId, Long houseId) throws Exception {
        UserHouseExample userHouseExample = new UserHouseExample();
        UserHouseExample.Criteria criteria = userHouseExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andHouseIdEqualTo(houseId);
        List<UserHouse> checkUserHouse = userHouseMapper.selectByExample(userHouseExample);
        if (checkUserHouse.size() > 0) {
            return false;
        }

        House house = houseMapper.selectByPrimaryKey(houseId);
        if (house == null) {
            return false;
        }

        UserHouse userHouse = new UserHouse();
        userHouse.setUserId(userId);
        userHouse.setHouseId(houseId);
        ClassUtil.setDefaultValues(userHouse);
        int result = userHouseMapper.insert(userHouse);
        if (result < 1) {
            return false;
        }

        return true;
    }

    /**
     * 收藏信息
     *
     * @param userId
     * @param houseIdList
     * @return
     */
    @Override
    public boolean collectHouseList(Long userId, List<Long> houseIdList) throws Exception {
        User user = userMapper.selectByPrimaryKey(userId);

        if (user == null) {
            throw new Exception("登录过期");
        }
        if (houseIdList == null | houseIdList.size() == 0) {
            throw new Exception("没选中信息");
        }

        for (Long houseId : houseIdList) {
            collectHouse(userId, houseId);
        }
        return true;
    }

    /**
     * 备注信息
     *
     * @param userHouseId
     * @param remark
     * @return
     */
    @Override
    public boolean remarkHouseInfo(Long userHouseId, String remark) {
        UserHouse userHouse = userHouseMapper.selectByPrimaryKey(userHouseId);
        userHouse.setRemark(remark);
        int result = userHouseMapper.updateByPrimaryKey(userHouse);
        if (result < 1) {
            return false;
        }

        return true;
    }
}
