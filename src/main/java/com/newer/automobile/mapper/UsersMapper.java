package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import com.newer.automobile.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UsersMapper  {
    //根据用户名查询
    public Users loadUserByUsername(@Param("uname") String uname);

    //用户注册
    @Insert("insert into users values(null,#{name},#{email},#{pwd},null,1,1,null,null)")
    public int regUser(@Param("name") String name, @Param("email") String email, @Param("pwd") String pwd);

    //用户登录
    @Select("select uname,uemail,upwd,uphone from users where uemail=#{email} and upwd=#{pwd}")
    public Users queryLogin(@Param("email") String email, @Param("pwd") String pwd);

    //根据邮箱查询密码
    @Select("select upwd from users where uemail = #{uemail}")
    public Users queryPwd(@Param("uemail")String uemail);

    //根据用户名查询邮箱
    @Select("select uemail from users where uname =#{uname}")
    public Users queryEmail(@Param("uname")String uname);

    //修改密码
    @Update("update users set upwd = #{upwd} where uname = #{uname}")
    public int updPwd(@Param("upwd") String upwd,@Param("uname")String uname);

}

