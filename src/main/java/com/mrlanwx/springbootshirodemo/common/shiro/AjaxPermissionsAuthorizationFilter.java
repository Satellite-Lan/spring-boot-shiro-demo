package com.mrlanwx.springbootshirodemo.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.mrlanwx.springbootshirodemo.common.enums.CodeEnum;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 14:43
 * @Description:
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", CodeEnum.E_20011.getCode());
        jsonObject.put("returnMsg", CodeEnum.E_20011.getMessage());
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

    @Bean
    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }


}
