package com.roytuts.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.springmvc.model.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int row) throws SQLException {
		Teacher teacher = new Teacher();
		teacher.setJobcode(rs.getString("jobcode"));
		teacher.setExperiencelevel(rs.getString("experiencelevel"));
		teacher.setSkillset(rs.getString("skillset"));
		teacher.setTechnology(rs.getString("technology"));
		teacher.setUploadedby(rs.getString("uploadedby"));
		teacher.setDepartment(rs.getString("department"));
		return teacher;
	}

}