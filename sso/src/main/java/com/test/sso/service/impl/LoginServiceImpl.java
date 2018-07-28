package com.test.sso.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.sso.model.User;
import com.test.sso.service.IloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class LoginServiceImpl implements IloginService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFail")
    public User getUserFromService(String username){
        String serviceId = "user";
        String url = "http://" + serviceId + "/getUser/"+username ;
        return (User) this.restTemplate.getForObject(url, User.class);
    }

    public User getUserFail(String username){
        User user = new User();
        user.setUsername("用户信息服务异常！！");
        return user;
    }
}
