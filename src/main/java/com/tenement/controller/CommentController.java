package com.tenement.controller;

import com.alibaba.fastjson.JSONArray;
import com.tenement.common.util.Result;
import com.tenement.service.CommentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LXPENG on 2016/5/6.
 * 评论
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    private static final String COMMENT = "comment";

    @Autowired
    private CommentService commentService;

    /**
     * 请求房屋评论列表 进入评论页面
     *
     * @param userId
     * @param collectionId
     * @param model
     * @return
     */
    @RequestMapping(value = "/view")
    public String viewComments(@RequestParam Long userId,
                               @RequestParam Long collectionId,
                               Model model) {
        Result result = new Result();
        try {
            JSONArray jsonArray = commentService.getCommentList(userId, collectionId);
            result.setSuccessful(true);
            result.setData(jsonArray);
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());

        }

        model.addAttribute("commentList", result);
        return COMMENT;
    }

    /**
     * 评论房屋信息
     *
     * @param userId
     * @param collectionId
     * @param content
     * @return
     */
    @RequestMapping(value = "/commentInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result comment(@RequestParam Long userId,
                          @RequestParam Long collectionId,
                          @RequestParam String content) {
        Result result = new Result();

        if (StringUtils.isBlank(content)) {
            result.setSuccessful(false);
            result.setMsg("内容不能为空");
            return result;
        }
        try {
            boolean remarkResult = commentService.commentHouse(userId, collectionId, content);
            if (!remarkResult) {
                result.setSuccessful(false);
                result.setMsg("评论失败");
                return result;
            } else {
                result.setSuccessful(true);
                result.setMsg("评论成功");
            }
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }

        return result;
    }
}
