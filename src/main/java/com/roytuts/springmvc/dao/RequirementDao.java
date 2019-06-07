package com.roytuts.springmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roytuts.springmvc.mapper.RequirementRowMapper;
import com.roytuts.springmvc.model.Requirement;

@Repository
@Transactional
public class RequirementDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Requirement getRequirement(final String jobcode) {
		Requirement requirement = jdbcTemplate.queryForObject("select * from jobdetails where JobCode = ?", new Object[] { jobcode },
				new RequirementRowMapper());
		return requirement;
	}

	public List<Requirement> getRequirements() {
		
		List<Requirement> requirements = jdbcTemplate.query("select * from jobdetails", new RequirementRowMapper());
		return requirements;
	}

	public void addRequirement(final Requirement requirement) {
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("jobdetails");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("uploadedby", requirement.getUploadedby());
		parameters.put("jobcode", requirement.getJobCode());
		parameters.put("department", requirement.getDepartment());
		parameters.put("experiencelevel", requirement.getExperiencelevel());
		parameters.put("Skillset", requirement.getSkillset());
		parameters.put("technology", requirement.getTechnology());
		
		simpleJdbcInsert.execute(parameters);
	}

	public void updateRequirement(final Requirement requirement) {
		jdbcTemplate.update("update jobdetails set ExperienceLevel = ?, SkillSet = ?,Technology = ?, Department = ?,uploadedBy = ? where JobCode = ?",
				new Object[] { requirement.getExperiencelevel(), requirement.getSkillset(), requirement.getTechnology(),requirement.getDepartment(),requirement.getUploadedby(),requirement.getJobCode()});
	}

	public void deleteRequirement(final String jobcode) {
		jdbcTemplate.update("delete from jobdetails where JobCode = ?", new Object[] { jobcode });
	}

}