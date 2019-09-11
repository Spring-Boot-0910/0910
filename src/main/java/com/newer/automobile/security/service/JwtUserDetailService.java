package com.newer.automobile.security.service;

import com.newer.automobile.domain.Users;
import com.newer.automobile.mapper.UsersMapper;
import com.newer.automobile.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
    业务逻辑层    安全校验
 */
@Service
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名查询用户,角色信息
        Users user = usersMapper.loadUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("not found username with"+username);
        }
            return JwtUserFactory.create(user);
    }
}
