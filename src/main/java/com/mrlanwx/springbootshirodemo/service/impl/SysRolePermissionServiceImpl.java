package com.mrlanwx.springbootshirodemo.service.impl;

import com.mrlanwx.springbootshirodemo.dao.SysRolePermissionMapper;
import com.mrlanwx.springbootshirodemo.model.SysRolePermission;
import com.mrlanwx.springbootshirodemo.model.SysRolePermissionExample;
import com.mrlanwx.springbootshirodemo.service.SysRolePermissionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:25
 * @Description:
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    @Transactional
    public SysRolePermission add(SysRolePermission sysRolePermission) {
        sysRolePermissionMapper.insertSelective(sysRolePermission);
        return sysRolePermission;
    }

    @Override
    public List<SysRolePermission> queryByRoleIds(List<Integer> roleids) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andRoleIdIn(roleids);
        return sysRolePermissionMapper.selectByExample(example);
    }

    @Override
    public List<Integer> getPermissionIdsByRoleIds(List<Integer> roleids) {
        List<SysRolePermission> sysRolePermissionList = queryByRoleIds(roleids);
        if (CollectionUtils.isEmpty(sysRolePermissionList)) {
            return null;
        }
        List<Integer> permissionIds = new ArrayList<>();
        for (SysRolePermission sysRolePermission : sysRolePermissionList) {
            permissionIds.add(sysRolePermission.getPermissionId());
        }
        return permissionIds;
    }
}
