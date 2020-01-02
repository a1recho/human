package com.dao;
import com.domain.User;
import java.util.List;

public interface UserDao {

    List<User> selectUser(User user);

    User selectUserByUsername(String userName);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);


}
