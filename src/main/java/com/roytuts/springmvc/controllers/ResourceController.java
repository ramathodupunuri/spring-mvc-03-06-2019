package com.roytuts.springmvc.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.roytuts.springmvc.model.InterviwerVO;
import com.roytuts.springmvc.model.ResourceVo;
import com.roytuts.springmvc.model.Teacher;
import com.roytuts.springmvc.service.ResourceService;
import com.roytuts.springmvc.service.TeacherService;

@Controller
public class ResourceController {

	private static String UPLOADED_FOLDER = "C://MyDocs//resumes//";

	final String from = "raghu88478@gmail.com"; // change accordingly
	final String password = "raghuvardhantalari"; // change accordingly
	String host = "smtp.gmail.com"; // or IP address
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "addResource")
	public String addPage(ModelMap resourceModel) {
		List<Teacher> teachers = teacherService.getTeachers();
		resourceModel.addAttribute("resources", teachers);
		return "addResource";
	}

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public String getResources(ModelMap resourceModel) {
		List<ResourceVo> resources = resourceService.getResources();
		resourceModel.addAttribute("resources", resources);
		return "resources";
	}


	@RequestMapping(value = "/add/Resource", method = RequestMethod.POST)
	public String addResource(@RequestParam(value = "jobCode", required = true) String jobCode,@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "middleName", required = true) String middleName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "emailId", required = true) String emailId,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "technology", required = true) String technology,
			@RequestParam(value = "noticePeriod", required = true) int noticePeriod,
			@RequestParam(value = "experienceLevel", required = true) double experienceLevel,
			@RequestParam(value = "currentSalary", required = true) double currentSalary,
			@RequestParam(value = "expectedSalary", required = true) double expectedSalary,
			@RequestParam(value = "finalStatus", required = true) String finalStatus,
			@RequestParam(value = "resume", required = true) MultipartFile  file, ModelMap resourceModel) throws IOException {
		ResourceVo resource = new ResourceVo();
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(1000); 
		StringBuilder jobcode = new StringBuilder();
		jobcode.append("resource").append("_").append(rand_int1); 
		resource.setResourceId(Integer.parseInt(jobcode.toString()));
		resource.setFirstName(firstName);
		resource.setMiddleName(middleName);
		resource.setLastName(lastName);
		resource.setEmailId(emailId);
		resource.setPhone(phone);
		resource.setTechnology(technology);
		resource.setNoticePeriod(noticePeriod);
		resource.setExperienceLevel(experienceLevel);
		resource.setCurrentSalary(currentSalary);
		resource.setExpectedSalary(expectedSalary);
		resource.setFinalStatus(finalStatus);
		resource.setJobCode(jobCode);
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		resource.setResumePath(path.toString());
		resourceService.addResource(resource);

		resourceModel.addAttribute("msg", "Resource added successfully");
		List<ResourceVo> resources = resourceService.getResources();
		resourceModel.addAttribute("resources", resources);
		return "resources";
	}



	@RequestMapping("/details/{jobCode}")
	public String getResourcesDetail(@PathVariable String jobCode, ModelMap resourceModel) {
		System.out.println("hi");
		ResourceVo resourcevo = resourceService.ResourcesDetails(jobCode);
		resourceModel.addAttribute("resourcevo", resourcevo);
		return "resourceDetails";
	}

	@RequestMapping("/addInterviewer/{jobCode}")
	public String addInterviewer(@PathVariable String jobCode, ModelMap resourceModel) {
		InterviwerVO interviewVo = new InterviwerVO();
		resourceService.addInterviewerToResource(jobCode,interviewVo);
		//resourceModel.addAttribute("resourcevo", resourcevo);
		return "addInterviewer";
	}


}