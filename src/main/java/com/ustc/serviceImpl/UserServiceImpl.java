package com.ustc.serviceImpl;

import com.ustc.dao.UserDao;
import com.ustc.entity.User;
import com.ustc.queryVo.UserVo;
import com.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.saveUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findUser(UserVo userVo) {
        return userDao.findUser(userVo);
    }
}
