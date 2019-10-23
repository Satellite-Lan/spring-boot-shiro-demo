package com.mrlanwx.springbootshirodemo.service.impl;


import com.mrlanwx.springbootshirodemo.dao.SysPermissionMapper;
import com.mrlanwx.springbootshirodemo.model.SysPermission;
import com.mrlanwx.springbootshirodemo.model.SysPermissionExample;
import com.mrlanwx.springbootshirodemo.service.SysPermissionService;
import com.mrlanwx.springbootshirodemo.service.SysRolePermissionService;
import com.mrlanwx.springbootshirodemo.service.SysUserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:23
 * @Description:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    @Transactional
    public SysPermission add(SysPermission sysPermission) {
        sysPermissionMapper.insertSelective(sysPermission);
        return sysPermission;
    }

    @Override
    @Transactional
    public SysPermission edit(SysPermission sysPermission) {
        sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        return sysPermission;
    }

    @Override
    public List<SysPermission> queryByUserId(Integer userid) {

        List<Integer> roleIdList = sysUserRoleService.getRoleIdsByUserId(userid);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return null;
        }

        List<Integer> permissionIds = sysRolePermissionService.getPermissionIdsByRoleIds(roleIdList);
        if (CollectionUtils.isEmpty(permissionIds)) {
            return null;
        }

        SysPermissionExample permissionExample = new SysPermissionExample();
        permissionExample.createCriteria().andIdIn(permissionIds);
        return sysPermissionMapper.selectByExample(permissionExample);
    }

    @Override
    public List<String> getPermissionCodesByUserId(Integer userid) {
        List<SysPermission> sysPermissionList = queryByUserId(userid);
        if (CollectionUtils.isEmpty(sysPermissionList)) {
            return null;
        }
        List<String> permissionCodes = new ArrayList<>();
        for (SysPermission sysPermission : sysPermissionList) {
            permissionCodes.add(sysPermission.getCode());
        }
        return permissionCodes;
    }
}
