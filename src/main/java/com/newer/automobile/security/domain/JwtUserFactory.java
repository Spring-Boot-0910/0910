package com.newer.automobile.security.domain;

import com.newer.automobile.domain.Authoritys;
import com.newer.automobile.domain.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * admins--转成--JwtUser对象
 */
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static UserDetails create(Users users) {
        return new JwtUser(users.getUid(), users.getUname(), users.getUpwd(), users.getType() == 0 ? false : true,
                users.getUemail(), users.getState(), maptoAuth(users.getAuthoritysList()));
    }

    private static Collection<? extends GrantedAuthority> maptoAuth(List<Authoritys> authorities) {
        return authorities.stream().map(Authority ->
                new SimpleGrantedAuthority(Authority.getAname().name())).
                collect(Collectors.toList());
    }
}
