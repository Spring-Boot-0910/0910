package com.newer.automobile.mapper;

import com.newer.automobile.domain.Maintain;
import org.apache.ibatis.annotations.Insert;

public interface MaintainMapper {

    /**
     * 请求服务
     *
     * @param maintain
     * @return
     */
    @Insert("insert into maintain values(null,#{mname},#{ucar},#{phone},#{email},#{Service},#{time},null,null)")
    public int maintainAdd(Maintain maintain);

}
