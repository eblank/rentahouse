package com.tenement.common.interceptor;

import com.tenement.common.baseController.BaseController;
import com.tenement.common.baseController.NoAuth;
import com.tenement.common.exception.AuthorizationException;
import com.tenement.mapper.UserMapper;
import com.tenement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LXPENG on 2016/4/27.
 */
public class AuthInterceptor implements HandlerInterceptor {
    private List<String> excluded;

    public void setExcluded(List<String> excludedUrls) {
        this.excluded = excludedUrls;
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (excluded != null && excluded.contains(httpServletRequest.getRequestURI())) {
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        boolean isAn = method.getMethod().isAnnotationPresent(NoAuth.class);

        BaseController base = new BaseController();
        try {
            base = (BaseController) ((HandlerMethod) handler).getBean();
            User currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
            base.setUser(currentUser);
            base.setUserInfo();
        } catch (Exception e) {

        }
        if (isAn) {
            return true;
        }

        User user = base.getUser();
        if (user == null) {
            throw new AuthorizationException("身份异常");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
