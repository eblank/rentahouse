package com.tenement.service;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by LXPENG on 2016/5/6.
 */
public interface CommentService {
    /**
     * 获取房屋信息评论
     *
     * @param userId
     * @param collectionId
     * @return
     */
    JSONArray getCommentList(Long userId, Long collectionId) throws Exception;

    /**
     * 评论房屋信息
     *
     * @param userId
     * @param collectionId
     * @param remark
     * @return
     */
    boolean commentHouse(Long userId, Long collectionId, String remark) throws Exception;

}
