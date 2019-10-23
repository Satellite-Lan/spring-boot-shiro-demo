package com.mrlanwx.springbootshirodemo.service.impl;

import com.mrlanwx.springbootshirodemo.dao.SysRoleMapper;
import com.mrlanwx.springbootshirodemo.model.SysRole;
import com.mrlanwx.springbootshirodemo.model.SysRoleExample;
import com.mrlanwx.springbootshirodemo.model.SysUserRole;
import com.mrlanwx.springbootshirodemo.service.SysRoleService;
import com.mrlanwx.springbootshirodemo.service.SysUserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:26
 * @Description:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    @Transactional
    public SysRole add(SysRole sysRole) {
        sysRoleMapper.insertSelective(sysRole);
        return sysRole;
    }

    @Override
    @Transactional
    public SysRole edit(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        return sysRole;
    }

    @Override
    public List<SysRole> queryByUserId(Integer userid) {

        List<SysUserRole> sysUserRoleList = sysUserRoleService.queryByUserId(userid);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }

        List<Integer> roleIdList = new ArrayList<>();
        for (SysUserRole sysUserRole : sysUserRoleList) {
            roleIdList.add(sysUserRole.getRoleId());
        }
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIdIn(roleIdList);
        return sysRoleMapper.selectByExample(roleExample);
    }
}
