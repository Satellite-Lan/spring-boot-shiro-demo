package com.mrlanwx.springbootshirodemo.service.impl;

import com.mrlanwx.springbootshirodemo.dao.SysUserRoleMapper;
import com.mrlanwx.springbootshirodemo.model.SysUserRole;
import com.mrlanwx.springbootshirodemo.model.SysUserRoleExample;
import com.mrlanwx.springbootshirodemo.service.SysUserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:27
 * @Description:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public SysUserRole add(SysUserRole sysUserRole) {
        sysUserRoleMapper.insertSelective(sysUserRole);
        return sysUserRole;
    }

    @Override
    public List<SysUserRole> queryByUserId(Integer userid) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userid);
        return sysUserRoleMapper.selectByExample(example);
    }

    @Override
    public List<Integer> getRoleIdsByUserId(Integer userid) {
        List<SysUserRole> sysUserRoleList = queryByUserId(userid);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIds = new ArrayList<>();
        for (SysUserRole sysUserRole : sysUserRoleList) {
            roleIds.add(sysUserRole.getRoleId());
        }
        return roleIds;
    }
}
