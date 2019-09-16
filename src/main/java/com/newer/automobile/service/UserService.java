package com.newer.automobile.service;

import com.newer.automobile.domain.Users;
import com.newer.automobile.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UsersMapper usersMapper;

    public int regUser(String name,String email,String pwd){
        return usersMapper.regUser(name,email,pwd);
    }

    public Users queryLogin(String email,String pwd){
        return usersMapper.queryLogin(email,pwd);
    }

}
