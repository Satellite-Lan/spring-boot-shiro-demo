package com.mrlanwx.springbootshirodemo.controller;



import com.mrlanwx.springbootshirodemo.common.response.ResponseData;
import com.mrlanwx.springbootshirodemo.model.SysUser;
import com.mrlanwx.springbootshirodemo.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:34
 * @Description:
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加用户
     *
     * @param sysUser 用户信息
     * @return 用户信息
     */
    @PostMapping("/add")
    @RequiresPermissions("user:add")
    public ResponseData add(@RequestBody SysUser sysUser) {
        return new ResponseData(sysUserService.add(sysUser));
    }

    /**
     * 获取用户详细
     *
     * @param userid 用户ID
     * @return
     */
    @GetMapping("/{userid}")
    @RequiresPermissions("user:detail")//具有 user:detail 权限的用户才能访问此方法
    public ResponseData detail(@PathVariable("userid") Integer userid) {
        return new ResponseData(sysUserService.detail(userid));
    }
}
