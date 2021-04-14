package com.turing.purchase.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.turing.purchase.Realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager defaultWebSecurityManager){
        //创建Shiro过滤器工厂对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //创建一个Map用来保存拦截器
          Map<String,String> map = new HashMap<>();
//        //配置公共资源（anon）---不用认证即可访问
          map.put("/login", "anon");
          map.put("/regist", "anon");
          map.put("/user/*", "anon");
//
//        //配置受限资源（authc）---需要认证和授权才能访问
  //      map.put("/*", "authc");//把拦截所有的过滤器放到最后authc anon
//
//
        //设置拦截后跳转的页面（默认是login.jsp，也可以修改）
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap (map);





        return  shiroFilterFactoryBean;
    }

    //2、配置安全管理器
    //注意：在springboot中必须创建默认的web安全管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm){
        //创建一个默认的web安全管理器
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置Realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //3、配置自定义Realm
    @Bean
    public UserRealm userRealm(){
        //创建自定义Realm
        UserRealm userRealm = new UserRealm();
        //创建一个匹配器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
        //设置散列次数
        matcher.setHashIterations(128);
        //设置加密匹配器
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    //4、配置shiro方言(如果不加，shiro标签识别不了)
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
