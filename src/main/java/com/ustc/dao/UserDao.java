package com.ustc.dao;

import com.ustc.entity.User;
import com.ustc.queryVo.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 实现注册
     * */
    void saveUser(User user);

    /**
     * 查询用户实现用户登录
     * */
    User findUser(UserVo userVo);
}
