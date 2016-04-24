package com.tenement.service;

/**
 * Created by LXPENG on 2016/4/22.
 */
public interface userService {
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

}
