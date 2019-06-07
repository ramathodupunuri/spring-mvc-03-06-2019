package com.roytuts.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.springmvc.model.InterviwerVO;

public class InterviwerRowMapper implements RowMapper<InterviwerVO> {

	@Override
	public InterviwerVO mapRow(ResultSet rs, int row) throws SQLException {
		InterviwerVO interviwerVO = new InterviwerVO();
		interviwerVO.setJobCode(rs.getString("jobcode"));
		interviwerVO.setInterviewedBy(rs.getString("interviewedBy"));
		interviwerVO.setInterviewId(rs.getInt("interviewId"));
		interviwerVO.setResourceId(rs.getInt("resourceId"));
		interviwerVO.setStatus(rs.getString("status"));
		interviwerVO.setRound(rs.getInt("round"));
		return interviwerVO;
	}

}