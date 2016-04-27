package com.tenement.service.serviceImplements;

import com.tenement.common.util.ClassUtil;
import com.tenement.mapper.CaptchaCodeMapper;
import com.tenement.mapper.UserMapper;
import com.tenement.model.CaptchaCode;
import com.tenement.model.User;
import com.tenement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CaptchaCodeMapper captchaCodeMapper;

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
        if (!password.equals(user.getLoginPassword())) {
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

    /**
     * 改密码
     *
     * @param password
     * @param passwordagain
     * @param validataCode
     * @return
     */
    @Override
    public boolean changePassword(String password, String passwordagain, String validataCode){
        CaptchaCode captchaCode = new CaptchaCode();
        captchaCode.setCode(validataCode);
        captchaCode.setValidated(false);
        captchaCode = captchaCodeMapper.selectBySelective(captchaCode);
        if (captchaCode == null) {
            return false;
        }
        captchaCode.setValidated(true);
        captchaCode.setValidatedTime(new Date());
        int result = captchaCodeMapper.updateByPrimaryKey(captchaCode);
        if (result < 1) {
            return false;
        }
        return true;
    }

    /**
     * 验证网址有效
     *
     * @param sid
     * @return
     */
    @Override
    public boolean cheackEmail(String sid) {
        return false;
    }
}
