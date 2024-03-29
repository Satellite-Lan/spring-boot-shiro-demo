package com.mrlanwx.springbootshirodemo.service;

import com.mrlanwx.springbootshirodemo.model.SysUserRole;

import java.util.List;

public interface SysUserRoleService {
    /**
     * 用户管理角色
     *
     * @param sysUserRole 用户角色
     * @return 用户角色
     */
    SysUserRole add(SysUserRole sysUserRole);

    /**
     * 通过用户ID获取管理角色ID
     *
     * @param userid 用户ID
     * @return
     */
    List<SysUserRole> queryByUserId(Integer userid);

    /**
     * 通过用户ID获取角色ID
     *
     * @param userid 用户ID
     * @return
     */
    List<Integer> getRoleIdsByUserId(Integer userid);
}
