package com.cxy.register.service.impl;

import com.cxy.background.entity.User;
import com.cxy.background.entity.UserExample;
import com.cxy.background.mapper.UserMapper;
import com.cxy.common.utils.EncodeUtils;
import com.cxy.register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements IRegisterService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {

        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0){
            return 0;
        }
        String encode = EncodeUtils.encode(user.getPassword());
        user.setPassword(encode);
        return userMapper.insertSelective(user);
    }

    @Override
    public int activity(Integer userId, String activityUUID) {

        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userId).andActivtUuidEqualTo(activityUUID);

        User user = new User();
        user.setId(userId);
        user.setStatus(1);
        return userMapper.updateByExampleSelective(user, example);
    }
}
