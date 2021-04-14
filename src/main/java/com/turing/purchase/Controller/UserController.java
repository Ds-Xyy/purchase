package com.turing.purchase.Controller;

import com.turing.purchase.entity.SysUsers;
import com.turing.purchase.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.acl.AclEntryImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;


    //登录
    @GetMapping("/userLogin")
    @ResponseBody
    public String userLogin(String userName, String passWord){
        System.out.println("来了");
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        try {
            //获取令牌
            subject.login(new UsernamePasswordToken(userName, passWord));

//            String principal = (String) token.getPrincipal();
//            SysUsers user=  userService.findByName(principal);
//            System.out.println(user.getId());
            //登录成功
            return "success";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "error";
    }


    //注册
    @PostMapping("/userRegist")
    @ResponseBody
    public String userRegist(SysUsers user){
        try {
            userService.regist(user);
     //       return "redirect:/login";
            return "success";
        }catch (Exception e){
            System.out.println("注册失败");
            e.printStackTrace();
          //  return "redirect:/regist";
            return  "error";
        }
    }

}
