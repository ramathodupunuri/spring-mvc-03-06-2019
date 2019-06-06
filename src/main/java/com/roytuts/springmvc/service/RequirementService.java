package com.roytuts.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.springmvc.dao.RequirementDao;
import com.roytuts.springmvc.model.Requirement;

@Service
public class RequirementService {

	@Autowired
	private RequirementDao requirementDao;

	public Requirement getRequirement(final String jobcode) {
		return requirementDao.getRequirement(jobcode);
	}

	public List<Requirement> getRequirements() {
		return requirementDao.getRequirements();
	}

	public void addRequirement(final Requirement requirement) {
		requirementDao.addRequirement(requirement);
	}

	public void updateRequirement(final Requirement requirement) {
		requirementDao.updateRequirement(requirement);
	}

	public void deleteRequirement(final String jobcode) {
		requirementDao.deleteRequirement(jobcode);
	}

}