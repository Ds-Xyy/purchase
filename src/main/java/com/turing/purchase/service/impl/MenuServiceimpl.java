package com.turing.purchase.service.impl;


import com.turing.purchase.entity.Attributes;
import com.turing.purchase.entity.Menu;
import com.turing.purchase.mapper.MenuMapper;
import com.turing.purchase.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceimpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findMenu() {
        //获取所有的一级菜单
        List<Menu> menus = menuMapper.findAll();
//        //遍历一级菜单
//        for(Menu menu:list){
//            //根据一级菜单的id找子菜单
//            menu.setChildren(menuMapper.findById(menu.getId()));
//        }
        return findFatherMenu(menus);
    }

    /**
     * 查找所有父菜单
     * @param menus 所有菜单
     * @return 父菜单的集合
     */
    private List<Menu> findFatherMenu(List<Menu> menus) {
        //创建一个父菜单集合
        List<Menu> fatherMenus = new ArrayList<>();
        //遍历所有菜单对象
        for(Menu menu:menus){
            //找到根节点
            if(menu.getPid() == 0){
                //设置跟节点的子节点
                menu.setChildren(findChildMenu(menu.getId(),menus));
                fatherMenus.add(menu);
            }
        }
        return fatherMenus;
    }

    /**
     * 查找所有子菜单
     * @param id 父菜单的id
     * @param menus 所有菜单
     * @return 所有子菜单
     */
    private List<Menu> findChildMenu(Integer id, List<Menu> menus) {
        //创建一个集合来保存子菜单
        List<Menu> childMenus = new ArrayList<>();
        //遍历所有菜单
        for(Menu menu:menus){
            if(menu.getPid() == id){
                //设置属性
                Attributes att=new Attributes();
                att.setUrl(menu.getUrl());
                //  att.setIcon(menu.getIcon());
                menu.setAttributes(att);
                childMenus.add(menu);
                //递归处理
                menu.setChildren(findChildMenu(menu.getId(),menus));
            }
        }
        return childMenus;
    }
}
