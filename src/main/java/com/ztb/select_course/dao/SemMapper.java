package com.ztb.select_course.dao;

import com.ztb.select_course.model.Sem;
import com.ztb.select_course.model.SemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SemMapper {
    int deleteByExample(SemExample example);

    @Delete({
        "delete from tb_sem",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_sem (id, sem)",
        "values (#{id,jdbcType=INTEGER}, #{sem,jdbcType=DATE})"
    })
    int insert(Sem record);

    int insertSelective(Sem record);

    List<Sem> selectByExample(SemExample example);

    @Select({
        "select",
        "id, sem",
        "from tb_sem",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Sem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sem record, @Param("example") SemExample example);

    int updateByExample(@Param("record") Sem record, @Param("example") SemExample example);

    int updateByPrimaryKeySelective(Sem record);

    @Update({
        "update tb_sem",
        "set sem = #{sem,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sem record);
}