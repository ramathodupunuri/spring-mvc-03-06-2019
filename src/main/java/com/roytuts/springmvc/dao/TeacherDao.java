package com.roytuts.springmvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roytuts.springmvc.mapper.TeacherRowMapper;
import com.roytuts.springmvc.model.Teacher;

@Repository
@Transactional
public class TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Teacher getTeacher(final int id) {
		Teacher teacher = jdbcTemplate.queryForObject("select * from teacher where id = ?", new Object[] { id },
				new TeacherRowMapper());
		return teacher;
	}

	public List<Teacher> getTeachers() {
		
		List<Teacher> teachers = jdbcTemplate.query("select * from jobdetails", new TeacherRowMapper());
		return teachers;
	}

	public void addTeacher(final Teacher teacher) {
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("jobdetails");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("uploadedby", teacher.getUploadedby());
		parameters.put("jobcode", teacher.getJobcode());
		parameters.put("department", teacher.getDepartment());
		parameters.put("experiencelevel", teacher.getExperiencelevel());
		parameters.put("Skillset", teacher.getSkillset());
		parameters.put("technology", teacher.getTechnology());
		
		simpleJdbcInsert.execute(parameters);
	}

	public void updateTeacher(final Teacher teacher) {
		/*jdbcTemplate.update("update teacher set name = ?, expertise = ? where id = ?",
				new Object[] { teacher.getName(), teacher.getExpertise(), teacher.getId() });*/
	}

	public void deleteTeacher(final int id) {
		jdbcTemplate.update("delete from teacher where id = ?", new Object[] { id });
	}

}