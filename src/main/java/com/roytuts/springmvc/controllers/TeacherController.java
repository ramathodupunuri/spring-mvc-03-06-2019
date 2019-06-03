package com.roytuts.springmvc.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roytuts.springmvc.model.Teacher;
import com.roytuts.springmvc.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/teacher/{id}") // by default Requestmethod is GET
	public String getTeacher(@PathVariable int id, ModelMap teacherModel) {
		Teacher teacher = teacherService.getTeacher(id);
		teacherModel.addAttribute("teacher", teacher);
		return "teacher";
	}

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public String getTeachers(ModelMap teacherModel) {
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping(value = "addTeacher")
	public String addPage() {
		return "add";
	}

	@RequestMapping(value = "/add/teacher", method = RequestMethod.POST)
	public String addTeacher(@RequestParam(value = "experiencelevel", required = true) String experiencelevel, @RequestParam(value = "skillset", required = true) String skillset,
			@RequestParam(value = "technology", required = true) String technology,@RequestParam(value = "department", required = true) String department, @RequestParam(value = "uploadedby", required = true) String uploadedby, ModelMap teacherModel) {
		
		Teacher teacher = new Teacher();
		String jobcode = genarateJobCode(technology,department);
		teacher.setJobcode(jobcode);
		teacher.setExperiencelevel(experiencelevel);
		teacher.setSkillset(skillset);
		teacher.setTechnology(technology);
		teacher.setUploadedby(uploadedby);
		teacher.setDepartment(department);
		teacherService.addTeacher(teacher);
		teacherModel.addAttribute("msg", "Teacher added successfully");
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	private String genarateJobCode(String technology, String department) {
		
		    Random rand = new Random(); 
		    int rand_int1 = rand.nextInt(1000); 
		    StringBuilder jobcode = new StringBuilder();
		    jobcode.append(technology).append("_").append(department).append("_").append(rand_int1);
		    return jobcode.toString();
		
	}

	@RequestMapping(value = "update/teacher/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap teacherModel) {
		teacherModel.addAttribute("id", id);
		Teacher teacher = teacherService.getTeacher(id);
		teacherModel.addAttribute("teacher", teacher);
		return "update";
	}

	@RequestMapping(value = "/update/teacher", method = RequestMethod.POST)
	public String updateTeacher(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap teacherModel) {
		Teacher teacher = new Teacher();
		/*teacher.setId(id);
		teacher.setName(name);
		teacher.setExpertise(expertise);
		teacherService.updateTeacher(teacher);
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		teacherModel.addAttribute("id", id);
		teacherModel.addAttribute("msg", "Teacher updated successfully");*/
		return "teachers";
	}

	@RequestMapping(value = "/delete/teacher/{id}")
	public String deleteTeacher(@PathVariable int id, ModelMap teacherModel) {
		teacherService.deleteTeacher(id);
		List<Teacher> teachers = teacherService.getTeachers();
		teacherModel.addAttribute("teachers", teachers);
		teacherModel.addAttribute("msg", "Teacher delted successfully");
		return "teachers";
	}

}