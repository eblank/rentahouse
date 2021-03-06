package com.tenement.common.baseController;

import com.tenement.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by LXPENG on 2016/4/27.
 */
public class BaseController {
    private Long userId;
    private User user;


    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /**
     * ModelAttribute
     * 放置在方法的形参上：表示引用Model中的数据
     * 放置在方法上面：表示请求该类的每个Action前都会首先执行它
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.response.setCharacterEncoding("utf-8");
        this.session = request.getSession();
    }

    public void setUserInfo() {
        this.userId = this.user.getId();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
