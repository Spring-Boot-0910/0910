package com.newer.automobile.mapper;

import com.newer.automobile.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;


public interface UsersMapper  {
    //根据用户名查询
    public Users loadUserByUsername(@Param("uname") String uname);

    //用户注册
    @Insert("insert into users values(null,#{name},#{email},#{pwd},null,1,1,null,null)")
    public int regUser(@Param("name") String name, @Param("email") String email,@Param("pwd")String pwd);

    //用户登录
    @Select("select uname,uemail,upwd,uphone from users where uemail=#{email} and upwd=#{pwd}")
    public Users queryLogin(@Param("email") String email,@Param("pwd") String pwd);

}

