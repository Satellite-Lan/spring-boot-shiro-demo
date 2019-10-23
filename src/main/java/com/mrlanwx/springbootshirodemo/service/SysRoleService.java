package com.mrlanwx.springbootshirodemo.service;


import com.mrlanwx.springbootshirodemo.model.SysRole;

import java.util.List;

public interface SysRoleService {

    /**
     * 添加角色
     *
     * @param sysRole 角色
     * @return 角色信息有ID了哦
     */
    SysRole add(SysRole sysRole);

    /**
     * 修改角色
     *
     * @param sysRole 角色
     * @return 修改后的角色信息
     */
    SysRole edit(SysRole sysRole);

    /**
     * 通过用户ID获取角色
     *
     * @param userid 用户ID
     * @return
     */
    List<SysRole> queryByUserId(Integer userid);
}
