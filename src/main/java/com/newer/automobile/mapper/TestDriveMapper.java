package com.newer.automobile.mapper;

import com.newer.automobile.domain.TestDrive;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDriveMapper {
    @Insert("insert into testdrive values(null,#{cid},#{uid},#{tname},#{tphone},#{temail},#{ttime})")
    public int addTestDrive(TestDrive testDrive);

    @Select("select t.tname,t.temail,t.tphone,t.ttime,c.cname,c.ctype,u.uname from Testdrive t,car c,users u where t.cid=c.cid and u.uid=t.uid limit #{startIndex},#{pageSize}")
    public List<TestDrive> queryAll(@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);

    @Select("select count(tid) from testdrive")
    public int countTid();
}
