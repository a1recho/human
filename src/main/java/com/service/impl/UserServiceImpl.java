package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUser(User user){
        return userDao.selectUser(user);
    }

    @Override
    public User selectUserByUsername(String username){
        return userDao.selectUserByUsername(username);
    }

    @Override
    public int insertUser(User user){
        int rows = userDao.insertUser(user);
        return rows;
    }

    @Override
    public int updateUser(User user){
        int rows = userDao.updateUser(user);
        return rows;
    }

    @Override
    public int deleteUserById(int id){
        return userDao.deleteUserById(id);
    }


}
