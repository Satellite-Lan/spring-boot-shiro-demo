package com.mrlanwx.springbootshirodemo.model;

import java.util.Date;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:45
 * @Description:
 */
public class SysUserRole {


    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
