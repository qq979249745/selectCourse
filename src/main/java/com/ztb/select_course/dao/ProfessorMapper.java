package com.ztb.select_course.dao;

import com.ztb.select_course.model.Professor;
import com.ztb.select_course.model.ProfessorExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProfessorMapper {
    int countByExample(ProfessorExample example);

    int deleteByExample(ProfessorExample example);

    @Delete({
        "delete from tb_professor",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_professor (id, account, ",
        "password, name, ",
        "college_id, phone)",
        "values (#{id,jdbcType=INTEGER}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{collegeId,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(Professor record);

    int insertSelective(Professor record);

    List<Professor> selectByExample(ProfessorExample example);

    @Select({
        "select",
        "id, account, password, name, college_id, phone",
        "from tb_professor",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Professor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByExample(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByPrimaryKeySelective(Professor record);

    @Update({
        "update tb_professor",
        "set account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "college_id = #{collegeId,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Professor record);
}