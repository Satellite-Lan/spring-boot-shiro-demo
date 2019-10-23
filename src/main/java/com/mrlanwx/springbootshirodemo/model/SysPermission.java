package com.mrlanwx.springbootshirodemo.model;

import java.util.Date;
/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:36
 * @Description:
 */
public class SysPermission {
    private Integer id;

    private String code;

    private String name;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
