package com.cxy.sso.controller;


import com.cxy.background.entity.User;
import com.cxy.common.pojo.State;
import com.cxy.common.utils.EncodeUtils;
import com.cxy.sso.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("login")
public class LoginController {


    @Autowired
    private ILoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("login")
    public String login(String username, String password, HttpServletResponse response){
        String encode = EncodeUtils.encode(password);
        User user = loginService.login(username, encode);
        if (user != null){
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            String key = "user:token:"+user.getId();
            redisTemplate.opsForValue().set(key,user);
            redisTemplate.expire(key, 30, TimeUnit.MINUTES);
            Cookie cookie = new Cookie("user_token",user.getId().toString());
            cookie.setMaxAge(1000*60*30);
            response.addCookie(cookie);
            return State.SUCCESS;
        }else {
            return State.ERROR;
        }
    }

    @RequestMapping("isLogin/{id}")
    public String checkIsLogin(@PathVariable String id){
        String key = "user:token:"+id;
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) redisTemplate.opsForValue().get(key);
        if (user != null){
            return  State.SUCCESS;
        }
        return State.ERROR;
    }


    @RequestMapping("logout/{id}")
    public String logout(@PathVariable String id){
        String key = "user:token:"+id;
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) redisTemplate.opsForValue().get(key);
        if (user != null){
            redisTemplate.delete(key);
            return  State.SUCCESS;
        }
        return State.ERROR;
    }
}
