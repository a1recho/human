package com.service;
import com.domain.User;
import java.util.List;

public interface UserService {

    List<User> selectUser(User user);

    User selectUserByUsername(String userName);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);


}
