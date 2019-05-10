package com.ztb.select_course.dao;

import com.ztb.select_course.model.College;
import com.ztb.select_course.model.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    @Delete({
        "delete from tb_college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_college (id, college_name, ",
        "manager, address, ",
        "degree_name, score, ",
        "study_time)",
        "values (#{id,jdbcType=INTEGER}, #{collegeName,jdbcType=VARCHAR}, ",
        "#{manager,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{degreeName,jdbcType=VARCHAR}, #{score,jdbcType=INTEGER}, ",
        "#{studyTime,jdbcType=INTEGER})"
    })
    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    @Select({
        "select",
        "id, college_name, manager, address, degree_name, score, study_time",
        "from tb_college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    College selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    @Update({
        "update tb_college",
        "set college_name = #{collegeName,jdbcType=VARCHAR},",
          "manager = #{manager,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "degree_name = #{degreeName,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=INTEGER},",
          "study_time = #{studyTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(College record);
}