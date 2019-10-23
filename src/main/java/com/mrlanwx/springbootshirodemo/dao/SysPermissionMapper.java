package com.mrlanwx.springbootshirodemo.dao;

import com.mrlanwx.springbootshirodemo.model.SysPermission;
import com.mrlanwx.springbootshirodemo.model.SysPermissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}
