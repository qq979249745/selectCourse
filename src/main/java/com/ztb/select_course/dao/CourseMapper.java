package com.ztb.select_course.dao;

import com.ztb.select_course.model.Course;
import com.ztb.select_course.model.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    @Delete({
        "delete from tb_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_course (id, name, ",
        "course_score, rank, ",
        "fee)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{courseScore,jdbcType=INTEGER}, #{rank,jdbcType=VARCHAR}, ",
        "#{fee,jdbcType=INTEGER})"
    })
    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    @Select({
        "select",
        "id, name, course_score, rank, fee",
        "from tb_course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update tb_course",
        "set name = #{name,jdbcType=VARCHAR},",
          "course_score = #{courseScore,jdbcType=INTEGER},",
          "rank = #{rank,jdbcType=VARCHAR},",
          "fee = #{fee,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}