package com.newer.automobile.mapper;

import com.newer.automobile.domain.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

public interface UsersMapper {
    public Users loadUserByUsername(@Param("uname") String uname);
}
