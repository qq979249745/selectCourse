package com.ztb.select_course.dao;

import com.ztb.select_course.model.Registrar;
import com.ztb.select_course.model.RegistrarExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RegistrarMapper {
    int countByExample(RegistrarExample example);

    int deleteByExample(RegistrarExample example);

    @Delete({
        "delete from tb_registrar",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_registrar (id, account, ",
        "password, phone)",
        "values (#{id,jdbcType=INTEGER}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(Registrar record);

    int insertSelective(Registrar record);

    List<Registrar> selectByExample(RegistrarExample example);

    @Select({
        "select",
        "id, account, password, phone",
        "from tb_registrar",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Registrar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Registrar record, @Param("example") RegistrarExample example);

    int updateByExample(@Param("record") Registrar record, @Param("example") RegistrarExample example);

    int updateByPrimaryKeySelective(Registrar record);

    @Update({
        "update tb_registrar",
        "set account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Registrar record);
}