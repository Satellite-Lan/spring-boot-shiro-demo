package com.mrlanwx.springbootshirodemo.vo;

import com.mrlanwx.springbootshirodemo.model.SysUser;
import java.util.List;
/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:47
 * @Description:
 */
public class UserVO extends SysUser {

    //令牌
    private String token;

    /**
     * 权限列表
     */
    private List<String> permissions;

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
