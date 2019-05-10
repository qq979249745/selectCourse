package com.ztb.select_course.dao;

import com.ztb.select_course.model.CourseOffering;
import com.ztb.select_course.model.CourseOfferingExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseOfferingMapper {
    int countByExample(CourseOfferingExample example);

    int deleteByExample(CourseOfferingExample example);

    @Delete({
        "delete from tb_courseoffering",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_courseoffering (id, sem_id, ",
        "course_id, professor_id, ",
        "prerequisite, order_num)",
        "values (#{id,jdbcType=INTEGER}, #{semId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{professorId,jdbcType=INTEGER}, ",
        "#{prerequisite,jdbcType=INTEGER}, #{orderNum,jdbcType=INTEGER})"
    })
    int insert(CourseOffering record);

    int insertSelective(CourseOffering record);

    List<CourseOffering> selectByExample(CourseOfferingExample example);

    @Select({
        "select",
        "id, sem_id, course_id, professor_id, prerequisite, order_num",
        "from tb_courseoffering",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CourseOffering selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseOffering record, @Param("example") CourseOfferingExample example);

    int updateByExample(@Param("record") CourseOffering record, @Param("example") CourseOfferingExample example);

    int updateByPrimaryKeySelective(CourseOffering record);

    @Update({
        "update tb_courseoffering",
        "set sem_id = #{semId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "professor_id = #{professorId,jdbcType=INTEGER},",
          "prerequisite = #{prerequisite,jdbcType=INTEGER},",
          "order_num = #{orderNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseOffering record);
}