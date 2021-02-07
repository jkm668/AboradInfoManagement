package com.ustc.service;

import com.ustc.entity.User;
import com.ustc.queryVo.UserVo;

public interface UserService {
    void saveUser(User user);
    User findUser(UserVo userVo);
}
