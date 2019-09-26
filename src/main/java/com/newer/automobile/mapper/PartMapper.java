package com.newer.automobile.mapper;

import com.newer.automobile.domain.Part;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PartMapper {

    /**
     * 查询
     * @return
     */
    public List<Part> partByPartType();

    /**
     * 根据id查询
     * @return
     */
    @Select("select * from part where pid=#{pid}")
    public Part partById(@Param("pid")Integer pid);

    /**
     * 查询相同类型的数据
     * @param partType
     * @return
     */
    @Select("select * from part where partType=#{partType}")
    public List<Part> partByType(@Param("partType")String partType);

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @param partType
     * @return
     */
    public List<Part> partSel(@Param("startIndex") int startIndex,
                              @Param("pageSize") int pageSize,
                              @Param("partType")String partType);

    /**
     * 所有零件数量
     * @param partType
     * @return
     */
    @Select("select count(*) from part where partType=#{partType}")
    public int count(@Param("partType")String partType);

    /**
     * 添加零件
     * @param part
     * @return
     */
    @Insert("insert into part values(null,#{pname},#{picture},#{pprice},#{partType},#{describes},null,null)")
    public int partAdd(Part part);

    /**
     * 删除零件
     * @param pid
     * @return
     */
    @Delete("delete from part where pid=#{pid}")
    public int partDel(@Param("pid")Integer pid);

    /**
     * 修改零件
     * @param part
     * @return
     */
    @Update("update part set pname=#{pname},picture=#{picture},pprice=#{pprice},partType=#{partType},describes=#{describes} where pid=#{pid}")
    public int partUpd(Part part);

}
