package com.turing.purchase.service.impl;

import com.turing.purchase.Untils.SaltUtils;
import com.turing.purchase.entity.SysUsers;
import com.turing.purchase.entity.SysUsersExample;
import com.turing.purchase.mapper.SysUsersMapper;
import com.turing.purchase.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {


    @Autowired
    SysUsersMapper  sysUsersMapper;


    @Override
    public void regist(SysUsers user) {
        //1、获取盐值
        String salt = SaltUtils.getSalt(10);
        //2、保存颜值
        user.setSalt(salt);
        //3、对用户的密码进行md5+盐+散列次数
        Md5Hash md5Hash = new Md5Hash(user.getPassWord(), salt, 128);
        //4、保存加密后的密码
        user.setPassWord(md5Hash.toHex());
        //5、保存用户
        sysUsersMapper.addUser(user);
    }

    @Override
    public SysUsers findByName(String name) {

        return sysUsersMapper.findByName(name)  ;
    }

    @Override
    public List<String> findPermissionsByUserName(Object userName) {
        return null;
    }

    @Override
    public List<String> findRolesByUserName(Object userName) {
        return null;
    }
}
