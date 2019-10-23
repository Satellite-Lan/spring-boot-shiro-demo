package com.mrlanwx.springbootshirodemo.service;

import com.mrlanwx.springbootshirodemo.vo.UserVO;

public interface LoginService {
    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    UserVO getUser(String username, String password);
}
