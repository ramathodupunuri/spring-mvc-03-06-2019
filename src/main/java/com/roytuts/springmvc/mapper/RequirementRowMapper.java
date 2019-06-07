package com.roytuts.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.springmvc.model.Requirement;

public class RequirementRowMapper implements RowMapper<Requirement> {

	@Override
	public Requirement mapRow(ResultSet rs, int row) throws SQLException {
		Requirement requirement = new Requirement();
		requirement.setJobCode(rs.getString("jobcode"));
		requirement.setExperiencelevel(rs.getString("experiencelevel"));
		requirement.setSkillset(rs.getString("skillset"));
		requirement.setTechnology(rs.getString("technology"));
		requirement.setUploadedby(rs.getString("uploadedby"));
		requirement.setDepartment(rs.getString("department"));
		return requirement;
	}

}