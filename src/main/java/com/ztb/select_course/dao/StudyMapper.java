package com.ztb.select_course.dao;

import com.ztb.select_course.model.Study;
import com.ztb.select_course.model.StudyExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudyMapper {
    int countByExample(StudyExample example);

    int deleteByExample(StudyExample example);

    @Delete({
        "delete from tb_study",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_study (id, stu_id, ",
        "sem_id, status, total_fee)",
        "values (#{id,jdbcType=INTEGER}, #{stuId,jdbcType=INTEGER}, ",
        "#{semId,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR}, #{totalFee,jdbcType=INTEGER})"
    })
    int insert(Study record);

    int insertSelective(Study record);

    List<Study> selectByExample(StudyExample example);

    @Select({
        "select",
        "id, stu_id, sem_id, status, total_fee",
        "from tb_study",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Study selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Study record, @Param("example") StudyExample example);

    int updateByExample(@Param("record") Study record, @Param("example") StudyExample example);

    int updateByPrimaryKeySelective(Study record);

    @Update({
        "update tb_study",
        "set stu_id = #{stuId,jdbcType=INTEGER},",
          "sem_id = #{semId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "total_fee = #{totalFee,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Study record);
}