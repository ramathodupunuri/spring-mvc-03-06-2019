package com.roytuts.springmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roytuts.springmvc.mapper.ResourceDetailRowMapper;
import com.roytuts.springmvc.mapper.TeacherRowMapper;
import com.roytuts.springmvc.model.ResourceVo;
import com.roytuts.springmvc.model.Teacher;

@Repository
@Transactional
public class ResourceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ResourceVo getResource(int id) {
		ResourceVo resource = jdbcTemplate.queryForObject("select * from teacher where id = ?", new Object[] { id },
				new ResourceDetailRowMapper());
		return resource;
	}

	public List<ResourceVo> getResources() {
		List<ResourceVo> resourceBean = jdbcTemplate.query("select * from resources", new ResourceDetailRowMapper());
		return resourceBean;
	}

	public void addResource(ResourceVo resourceBean) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("resources");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("resourceId", resourceBean.getResourceId());
		parameters.put("firstName", resourceBean.getFirstName());
		parameters.put("phone", resourceBean.getPhone());
		parameters.put("lastName", resourceBean.getLastName());
		parameters.put("middleName", resourceBean.getMiddleName());
		parameters.put("emailId", resourceBean.getEmailId());
		parameters.put("technology", resourceBean.getTechnology());
		parameters.put("resume", resourceBean.getResumePath());
		parameters.put("experienceLevel", resourceBean.getExperienceLevel());
		parameters.put("noticePeriod", resourceBean.getNoticePeriod());
		parameters.put("currentSalary", resourceBean.getCurrentSalary());
		parameters.put("expectedSalary", resourceBean.getExpectedSalary());
		parameters.put("finalStatus", resourceBean.getFinalStatus());
		parameters.put("jobCode", resourceBean.getJobCode());
		simpleJdbcInsert.execute(parameters);

		
	}

	public void updateResource(ResourceVo resourceBean) {
		
	}

	public void deleteResource(int id) {
		// TODO Auto-generated method stub
		
	}

}
