package com.test.UserManage.service;

import com.test.UserManage.model.User;

import java.util.List;

public interface IUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectList();

    User getUserByUsername(String username);
}
