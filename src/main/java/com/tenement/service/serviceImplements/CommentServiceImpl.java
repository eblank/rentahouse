package com.tenement.service.serviceImplements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.tenement.common.util.ClassUtil;
import com.tenement.common.util.DateUtil;
import com.tenement.mapper.CommentMapper;
import com.tenement.mapper.HouseMapper;
import com.tenement.mapper.UserHouseMapper;
import com.tenement.mapper.UserMapper;
import com.tenement.model.*;
import com.tenement.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LXPENG on 2016/5/6.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private UserHouseMapper userHouseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 获取房屋信息评论
     *
     * @param userId
     * @param collectionId
     * @return
     */
    @Override
    public JSONArray getCommentList(Long userId, Long collectionId) throws Exception {
        JSONArray commentArray = new JSONArray();
        UserHouse userHouse = userHouseMapper.selectByPrimaryKey(collectionId);

        if (userHouse == null) {
            throw new Exception("收藏信息不存在");
        }

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new Exception("身份验证失败");
        }

        if (userHouse.getUserId() != userId) {
            throw new Exception("身份验证失败");
        }

        Long houseId = userHouse.getHouseId();

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria().andHouseEqualTo(houseId);
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        for (Comment comment : commentList) {
            User from = userMapper.selectByPrimaryKey(comment.getUser());
            Gson gson = new Gson();
            String commentJsonString = gson.toJson(comment);
            JSONObject commentJsonObject = JSONObject.parseObject(commentJsonString);
            Date date = comment.getCreateTime();
            String dateString = DateUtil.formatDateTime(date);
            commentJsonObject.put("createTime", dateString);
            //todo 评论者信息 补全
            JSONObject fromUser = new JSONObject();
            fromUser.put("fromId", from.getId());
            fromUser.put("fromNickname", from.getNickName());
            commentJsonObject.put("from", fromUser);
            commentArray.add(commentJsonObject);
        }

        return commentArray;
    }

    /**
     * 评论房屋信息
     *
     * @param userId
     * @param collectionId
     * @param content
     * @return
     */
    @Override
    public boolean commentHouse(Long userId, Long collectionId, String content) throws Exception {
        UserHouse userHouse = userHouseMapper.selectByPrimaryKey(collectionId);
        Long houseId = userHouse.getHouseId();
        House house = houseMapper.selectByPrimaryKey(houseId);

        if (house == null) {
            throw new Exception("房屋信息已不存在");
        }

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new Exception("身份验证错误");
        }
        Comment comment = new Comment();
        comment.setUser(userId);
        comment.setHouse(houseId);
        comment.setCreateTime(new Date());
        comment.setContent(content);
        ClassUtil.setDefaultValues(comment);

        int result = commentMapper.insert(comment);
        if (result < 1) {
            return false;
        }

        return true;
    }
}
