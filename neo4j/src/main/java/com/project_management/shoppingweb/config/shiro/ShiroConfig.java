package com.project_management.shoppingweb.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ShiroConfig{

    @Bean(name = "UserShiroRealm")
    public UserShiroRealm getUserRealm(){

        return new UserShiroRealm();
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getUserWebSecurityManager(@Qualifier("UserShiroRealm")UserShiroRealm UserShiroRealm){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(UserShiroRealm);
        return securityManager;
    }

    @Bean(name="userShiroFilterFactoryBean")
    public ShiroFilterFactoryBean getUserShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /*
            添加过滤器拦截(url)
                常用过滤器
                    anon: 无需拦截
                    authc: 必须认证才能访问
                    user: 如果使用rememberMe的功能可以直接访问
                    perms: 该资源必须得到资源权限才可以访问
                    role: 该资源必须得到角色权限才可以访问
         */


        Map<String,String> filterMap = new LinkedHashMap<String,String>();

//        filterMap.put("/person/sendemail","anon");
//        filterMap.put("/person/addregister","anon");
//
//        filterMap.put("/person/*", "authc");
//        filterMap.put("/logout", "logout");
//        filterMap.put("/moment/*", "authc");
//        filterMap.put("/message/*", "authc");


        //设置登录页面，authc没通过会跳转

        shiroFilterFactoryBean.setLoginUrl("/login");

        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;

    }


}
