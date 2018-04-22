package com.cxy.sso.service;

import com.cxy.background.entity.User;

public interface ILoginService {
    User login(String username, String password);
}
