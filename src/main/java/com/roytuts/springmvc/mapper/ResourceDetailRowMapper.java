package com.roytuts.springmvc.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.springmvc.model.ResourceVo;


public class ResourceDetailRowMapper implements RowMapper<ResourceVo> {

	public ResourceVo mapRow(ResultSet rs, int row) throws SQLException {
		ResourceVo bean = new ResourceVo();
		
		bean.setResourceId(rs.getInt("ResourceId"));
		bean.setFirstName(rs.getString("FirstName"));
		bean.setMiddleName(rs.getString("MiddleName"));
		bean.setPhone(rs.getString("Phone"));
		bean.setLastName(rs.getString("LastName"));
		bean.setEmailId(rs.getString("EmailId"));
		bean.setTechnology(rs.getString("Technology"));
		bean.setResumePath(rs.getString("Resume"));
		bean.setExperienceLevel(rs.getInt("Experience"));
		bean.setNoticePeriod(rs.getInt("NoticePeriod"));
		bean.setCurrentSalary(rs.getInt("currentSalary"));
		bean.setExpectedSalary(rs.getInt("expectedSalary"));
		bean.setFinalStatus(rs.getString("FinalStatus"));
		bean.setJobCode(rs.getString("JobCode"));
		
		return bean;
	}

}