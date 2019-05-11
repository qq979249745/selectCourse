package com.ztb.select_course.controll;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.College;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/10 15:28
 * @Version 1.0
 */
@Controller
@RequestMapping("/registrar")
public class RegistrarController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/")
    public String registrar() {
        return "/registrar/registrar";
    }

    @ResponseBody
    @RequestMapping("/getProfessors")
    public RestResponse getProfessors() {
        return null;
    }

    @RequestMapping("/college")
    public String collegeManage() {
        return "/registrar/college";
    }

    @ResponseBody
    @RequestMapping("/getColleges")
    public RestResponse getColleges(@RequestParam(name = "page",defaultValue = "1")Integer page) {
        PageHelper.startPage(page,10);
        List<College> list=collegeService.getAll();
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 10));
    }
    @ResponseBody
    @RequestMapping("/getCollege")
    public RestResponse getCollege(Integer id) {
        System.out.println(id);
        College college = collegeService.getCollege(id);
        return RestResponse.success().add("data",college);
    }
    @PostMapping("/addCollege")
    @ResponseBody
    public RestResponse addCollege(@Valid College college, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return collegeService.addCollege(college) ? RestResponse.success().add("success", "添加成功")
                    : RestResponse.fail().add("error", "添加失败");
        }
    }
    @PostMapping("/modifyCollege")
    @ResponseBody
    public RestResponse modifyCollege(@Valid College college, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return collegeService.modifyCollege(college) ? RestResponse.success().add("success", "修改成功")
                    : RestResponse.fail().add("error", "修改失败");
        }
    }
}
