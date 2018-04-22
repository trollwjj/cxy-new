package com.cxy.sso.service.impl;

import com.cxy.background.entity.User;
import com.cxy.background.entity.UserExample;
import com.cxy.background.mapper.UserMapper;
import com.cxy.sso.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {

        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0){
            return  users.get(0);
        }
        return null;
    }
}
