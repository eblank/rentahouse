package com.tenement.serviceImplements;

import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.UserMapper;
import com.tenement.model.User;
import com.tenement.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LXPENG on 2016/4/22.
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户账号有效检测
     *
     * @param userAccount
     * @return
     */
    @Override
    public boolean checkAccount(String userAccount) {
        User user = userMapper.selectByAccount(userAccount);
        if (user != null) {
            return false;
        }
        return true;
    }

    /**
     * 用户登录
     * 查找用户
     * 判断用户是否存在
     * 密码是否匹配
     *
     * @param userAccount
     * @param password
     * @return 用户昵称
     */
    @Override
    public String userLogin(String userAccount, String password) throws Exception {
        User user = userMapper.selectByAccount(userAccount);
        if (user == null) {
            throw new Exception("用户名错误");
        }
        if (! password.equals(user.getLoginPassword())) {
            throw new Exception("密码错误");
        }

        return user.getNickName();
    }

    /**
     * 用户注册
     *
     * @param email
     * @param nickname
     * @param password
     * @return
     */
    @Override
    public boolean userRegister(String email, String nickname, String password) {
        User user = new User(nickname, new Date(), email, password);
        ClassUtil.setDefaultValues(user);
        int result = userMapper.insert(user);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
