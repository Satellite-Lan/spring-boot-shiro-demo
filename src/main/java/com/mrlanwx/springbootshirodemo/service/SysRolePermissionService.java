package com.mrlanwx.springbootshirodemo.service;

import com.mrlanwx.springbootshirodemo.model.SysRolePermission;

import java.util.List;

public interface SysRolePermissionService {

    /**
     * 角色关联权限
     *
     * @param sysRolePermission 角色关联的权限
     * @return 角色关联权限，带ID的
     */
    SysRolePermission add(SysRolePermission sysRolePermission);

    /**
     * 通过角色ID获取权限
     *
     * @param roleids 角色ID
     * @return
     */
    List<SysRolePermission> queryByRoleIds(List<Integer> roleids);

    /**
     * 通过角色ID获取权限ID
     *
     * @param roleids 角色ID
     * @return
     */
    List<Integer> getPermissionIdsByRoleIds(List<Integer> roleids);
}
