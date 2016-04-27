package com.tenement.service;

import com.tenement.model.CaptchaCode;

/**
 * Created by LXPENG on 2016/4/27.
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param email
     * @param nickname
     * @param password
     * @return
     */
    boolean userRegister(String email, String nickname, String password);

    /**
     * 用户登录
     *
     * @param userAccount
     * @param password
     * @return
     */
    String userLogin(String userAccount, String password) throws Exception;

    /**
     * 用户账号有效检测
     *
     * @param userAccount
     * @return
     */
    boolean checkAccount(String userAccount);

    /**
     * 验证网址有效
     *
     * @param sid
     * @return
     */
    boolean cheackEmail(String sid);

    /**
     * 改密码
     *
     * @param password
     * @param passwordagain
     * @param validataCode
     * @return
     */
    boolean changePassword(String password, String passwordagain, String validataCode);
}
