package com.mrlanwx.springbootshirodemo.model;

import java.util.Date;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:42
 * @Description:
 */
public class SysRolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
