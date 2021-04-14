package com.turing.purchase.service;

import com.turing.purchase.entity.SysUsers;

import java.util.List;

public interface UserService {

    //注册
    void regist(SysUsers user);

    //查询
    SysUsers findByName(String name);

    /**
     * 根据用户名查询用户的权限字符串集合
     * @param userName 用户名
     * @return 权限字符串集合
     */
    List<String> findPermissionsByUserName(Object userName);

    /**
     * 根据用户名查询用户的角色集合
     * @param userName 用户名
     * @return 角色集合
     */
    List<String> findRolesByUserName(Object userName);

}
