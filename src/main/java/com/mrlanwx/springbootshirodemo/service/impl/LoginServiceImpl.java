package com.mrlanwx.springbootshirodemo.service.impl;

import com.mrlanwx.springbootshirodemo.common.utils.BeanUtil;
import com.mrlanwx.springbootshirodemo.model.SysUser;
import com.mrlanwx.springbootshirodemo.service.LoginService;
import com.mrlanwx.springbootshirodemo.service.SysPermissionService;
import com.mrlanwx.springbootshirodemo.service.SysUserService;
import com.mrlanwx.springbootshirodemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:21
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserVO getUser(String username, String password) {
        SysUser sysUser = sysUserService.queryByUsernameAndPassword(username, password);
        UserVO userVO = BeanUtil.copyProperties(sysUser, UserVO.class);
        userVO.setPermissions(sysPermissionService.getPermissionCodesByUserId(sysUser.getId()));
        userVO.setToken(getToken(username));

        return userVO;
    }

    private String getToken(String username) {
        return DigestUtils.md5DigestAsHex((username + System.currentTimeMillis()).getBytes());
    }
}
