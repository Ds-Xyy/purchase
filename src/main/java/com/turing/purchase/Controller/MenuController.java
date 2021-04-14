package com.turing.purchase.Controller;

import com.turing.purchase.entity.Menu;
import com.turing.purchase.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/")
    @ResponseBody
    public List<Menu> find(){
        return   menuService.findMenu();
    }
}
