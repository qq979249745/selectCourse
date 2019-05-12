package com.ztb.select_course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.Professor;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 10:18
 * @Version 1.0
 */
@Controller
@RequestMapping("/registrar")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor")
    public String professorManage() {
        return "/registrar/professor";
    }


    @ResponseBody
    @RequestMapping("/getProfessors")
    public RestResponse getProfessors(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        PageHelper.startPage(page, 10);
        List<Professor> list = professorService.getAll();
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 10));
    }

    @ResponseBody
    @RequestMapping("/getProfessor")
    public RestResponse getProfessor(Integer id) {
        Professor professor = professorService.getProfessor(id);
        return RestResponse.success().add("data", professor);
    }

    @PostMapping("/addProfessor")
    @ResponseBody
    public RestResponse addProfessor(@Valid Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return professorService.addProfessor(professor) ? RestResponse.success().add("success", "添加成功")
                    : RestResponse.fail().add("error", "添加失败");
        }
    }

    @PostMapping("/modifyProfessor")
    @ResponseBody
    public RestResponse modifyProfessor(@Valid Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return professorService.modifyProfessor(professor) ? RestResponse.success().add("success", "修改成功")
                    : RestResponse.fail().add("error", "修改失败");
        }
    }

    @GetMapping("/deleteProfessor")
    @ResponseBody
    public RestResponse deleteProfessor(Integer id) {
        return professorService.deleteProfessor(id) ? RestResponse.success().add("message", "删除成功")
                : RestResponse.fail().add("message", "删除失败");
    }
}
