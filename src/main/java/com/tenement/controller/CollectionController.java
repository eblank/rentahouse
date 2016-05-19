package com.tenement.controller;

import com.alibaba.fastjson.JSONArray;
import com.tenement.common.baseController.BaseController;
import com.tenement.common.util.Result;
import com.tenement.service.CollectionsHouseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LXPENG on 2016/5/5.
 * 收藏信息
 */
@Controller
@RequestMapping(value = "/collection")
public class CollectionController extends BaseController {
    @Autowired
    private CollectionsHouseService collectionsHouseService;


    /**
     * 获取个人收藏的数据
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
    @RequestMapping(value = "/houseList")
    @ResponseBody
    public Result getCollectioneHouseInfo(@RequestParam(required = false, defaultValue = "") String userId,
                                 @RequestParam(required = false, defaultValue = "") String location,
                                 @RequestParam(required = false, defaultValue = "") String price,
                                 @RequestParam(required = false, defaultValue = "") String roomNumber,
                                 @RequestParam(required = false, defaultValue = "") String rentType,
                                 @RequestParam(required = false, defaultValue = "") String toward,
                                 @RequestParam(required = false, defaultValue = "") String decoration) {
        Result result = new Result();
        if (StringUtils.isBlank(userId)) {
            result.setSuccessful(false);
            result.setMsg("用户过期");
            return result;
        }
        //从数据库读取数据
        List houseList = collectionsHouseService.getUserHouseList(userId, location, price, roomNumber, rentType, toward, decoration);
        if (houseList.size() < 1) {
            result.setSuccessful(false);
            result.setMsg("没有数据");
        } else {
            result.setData(houseList);
        }
        return result;
    }

    /**
     * 收藏信息
     *
     * @param userId
     * @param houseIdListString
     * @return
     */
    @RequestMapping(value = "/collectHouse", method = RequestMethod.POST)
    @ResponseBody
    public Result collectHouse(@RequestParam Long userId,
                               @RequestParam(required = false) String houseIdListString) {
        List<Long> houseIdList = JSONArray.parseArray(houseIdListString, Long.class);
        Result result = new Result();
        try {
            boolean collecteResult = collectionsHouseService.collectHouseList(userId,houseIdList);
            if (!collecteResult) {
                result.setSuccessful(false);
                result.setMsg("收藏失败");
            } else {
                result.setSuccessful(true);
                result.setMsg("收藏成功");
            }
        }catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 取消收藏信息
     *
     * @param userId 用户id
     * @param collectionIdListString 收藏信息id列表 string
     * @return
     */
    @RequestMapping(value = "/cancelCollect", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelCollectHouse(@RequestParam Long userId,
                                     @RequestParam String collectionIdListString) {
        List<Long> collectionIdList = JSONArray.parseArray(collectionIdListString, Long.class);
        Result result = new Result();
        try {
            boolean cancelResult = collectionsHouseService.cancelCollect(userId, collectionIdList);
            if (!cancelResult) {
                result.setSuccessful(false);
                result.setMsg("删除失败");
            } else {
                result.setSuccessful(true);
                result.setMsg("删除成功");
            }
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg("删除失败");
        }

        return result;
    }


    /**
     * 保存备注信息
     *
     * @param collectionId
     * @param remark
     * @return
     */
    @RequestMapping(value = "/remark", method = RequestMethod.POST)
    @ResponseBody
    public Result remarkHouseInfo(@RequestParam Long collectionId,
                                  @RequestParam String remark) {
        Result result = new Result();
        if (StringUtils.isBlank(remark)) {
            result.setSuccessful(false);
            result.setMsg("内容不能为空");
            return result;
        }
        boolean remarkResult = collectionsHouseService.remarkHouseInfo(collectionId, remark);
        if (!remarkResult) {
            result.setSuccessful(false);
            result.setMsg("备注失败");
            return result;
        }
        result.setSuccessful(true);
        result.setMsg("备注成功");
        return result;
    }

    /**
     * 获取备注信息
     *
     * @param collectionId 收藏信息id
     * @return
     */
    @RequestMapping(value = "/getRemark", method = RequestMethod.GET)
    @ResponseBody
    public Result getCollectionRemark(@RequestParam(defaultValue = "") Long collectionId) {
        Result result = new Result();
        try {
            String remark = collectionsHouseService.getCollectionRemark(collectionId);
            result.setSuccessful(true);
            result.setMsg("获取备注成功");
            result.setData(remark);
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }

        return result;
    }
}
