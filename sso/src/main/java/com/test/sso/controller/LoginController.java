package com.test.sso.controller;

import com.test.sso.model.User;
import com.test.sso.service.IloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "",produces = "application/json")
public class LoginController {

    @Autowired
    private IloginService loginService;

    @RequestMapping("/login/{username}/{password}")
    public Object login(@PathVariable String username, @PathVariable String password, HttpSession session) {
        User user = null;
        HashMap<String, Object> result = new HashMap<>();
        user = loginService.getUserFromService(username);
        if(user!=null && user.getId()==null){
            result.put("code","error");
            result.put("msg","用户信息服务异常！！！");
            return result;
        }
        if(user==null){
            result.put("code","error");
            result.put("msg","账号不存在!！");
            return result;
        }
        if(!password.equals(user.getPassword())){
            result.put("code","error");
            result.put("msg","密码错误！");
            return result;
        }
        result.put("code","success");
        result.put("msg","登录成功！");
        result.put("user",user);
        session.setAttribute("user",user);
        return result;
    }

}
