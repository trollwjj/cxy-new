package com.cxy.register.service;

import com.cxy.background.entity.User;

public interface IRegisterService {
    int register(User user);

    int activity(Integer userId, String activityUUID);
}
