package com.ztb.select_course.dao;

import com.ztb.select_course.model.StudyProgram;
import com.ztb.select_course.model.StudyProgramExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudyProgramMapper {
    int countByExample(StudyProgramExample example);

    int deleteByExample(StudyProgramExample example);

    @Delete({
        "delete from tb_studyprogram",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_studyprogram (id, study_id, ",
        "courseOffering_id, state)",
        "values (#{id,jdbcType=INTEGER}, #{studyId,jdbcType=INTEGER}, ",
        "#{courseofferingId,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR})"
    })
    int insert(StudyProgram record);

    int insertSelective(StudyProgram record);

    List<StudyProgram> selectByExample(StudyProgramExample example);

    @Select({
        "select",
        "id, study_id, courseOffering_id, state",
        "from tb_studyprogram",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    StudyProgram selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyProgram record, @Param("example") StudyProgramExample example);

    int updateByExample(@Param("record") StudyProgram record, @Param("example") StudyProgramExample example);

    int updateByPrimaryKeySelective(StudyProgram record);

    @Update({
        "update tb_studyprogram",
        "set study_id = #{studyId,jdbcType=INTEGER},",
          "courseOffering_id = #{courseofferingId,jdbcType=INTEGER},",
          "state = #{state,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudyProgram record);
}