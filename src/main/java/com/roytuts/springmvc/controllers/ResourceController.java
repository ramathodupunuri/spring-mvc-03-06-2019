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
import com.roytuts.springmvc.model.Requirement;
import com.roytuts.springmvc.model.ResourceVo;
import com.roytuts.springmvc.service.RequirementService;
import com.roytuts.springmvc.service.ResourceService;

@Controller
public class ResourceController {

	private static String UPLOADED_FOLDER = "C://MyDocs//resumes//";

	final String from = "raghu88478@gmail.com"; // change accordingly
	final String password = "raghuvardhantalari"; // change accordingly
	String host = "smtp.gmail.com"; // or IP address
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RequirementService requirementService;

	@RequestMapping(value = "add/{jobCode}")
	public String addPage(@PathVariable String jobCode, ModelMap resourceModel) {
		List<Requirement> requirements= requirementService.getRequirements();
		resourceModel.addAttribute("resources", requirements);
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
		int value = Integer.parseInt("2019")+Integer.parseInt(String.valueOf(rand_int1));
		resource.setResourceId(value);
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
		List<InterviwerVO> inteviewers = resourceService.getInteviewers(jobCode);
		resourceModel.addAttribute("resourcevo", resourcevo);
		resourceModel.addAttribute("inteviewers", inteviewers);
		resourceModel.addAttribute("resourceId", resourcevo.getResourceId());
		return "resourceDetails";
	}

	@RequestMapping("/addInterviewer/{jobCode}")
	public String addInterviewer(@PathVariable String jobCode, ModelMap resourceModel) {
		ResourceVo resourcevo = resourceService.ResourcesDetails(jobCode);
		resourceModel.addAttribute("resourceId", resourcevo.getResourceId());
		return "addInterviewer";
	}

	@RequestMapping(value = "deleteResource/{jobCode}" , method = RequestMethod.GET)
	public String deleteRequirement(@PathVariable("jobCode")  String jobcode, ModelMap requirementModel) {
		resourceService.deleteResource(jobcode);
		List<ResourceVo> resources = resourceService.getResources();
		requirementModel.addAttribute("resources", resources);
		requirementModel.addAttribute("msg", "Requirement deleted successfully");
		return "resources";
	}
	
	
	@RequestMapping(value = "/add/Interviewer", method = RequestMethod.POST)
	public String addInterviwerToResource(@RequestParam(value = "jobCode", required = true) String jobCode,@RequestParam(value = "interviewId", required = true) int interviewId,
			@RequestParam(value = "Round", required = true) int round,@RequestParam(value = "resourceId", required = true) int resourceId,
			@RequestParam(value = "interviewedBy", required = true) String interviewedBy,
			@RequestParam(value = "Status", required = true) String status , ModelMap resourceModel) throws IOException {
		InterviwerVO interviewVo = new InterviwerVO();
		interviewVo.setInterviewedBy(interviewedBy);
		interviewVo.setInterviewId(interviewId);
		interviewVo.setRound(round);
		interviewVo.setJobCode(jobCode);
		interviewVo.setResourceId(resourceId);
		interviewVo.setStatus(status);
		resourceService.addInterviewerToResource(jobCode,interviewVo);
		resourceModel.addAttribute("msg", "Resource added successfully");
		List<ResourceVo> resources = resourceService.getResources();
		resourceModel.addAttribute("resources", resources);
		return "resources";
	}


	
	

}
