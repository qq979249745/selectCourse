package com.ztb.select_course.dao;

import com.ztb.select_course.model.Student;
import com.ztb.select_course.model.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    @Delete({
        "delete from tb_student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_student (id, account, ",
        "password, name, ",
        "college_id, address, ",
        "birthday, phone)",
        "values (#{id,jdbcType=INTEGER}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{collegeId,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "s.id, account, password, name, college_id, s.address, birthday, phone ,college_name",
        "from tb_student s join tb_college c on s.college_id=c.id",
        "where s.id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update tb_student",
        "set account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "college_id = #{collegeId,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}