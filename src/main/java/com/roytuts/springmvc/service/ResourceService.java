package com.roytuts.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.springmvc.dao.ResourceDao;
import com.roytuts.springmvc.model.InterviwerVO;
import com.roytuts.springmvc.model.ResourceVo;

@Service
public class ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;

	public List<ResourceVo> getResources() {
		return resourceDao.getResources();
	}

	public void addResource(final ResourceVo resource) {
		resourceDao.addResource(resource);
	}

	public void updateResource(final ResourceVo resource) {
		resourceDao.updateResource(resource);
	}

	public void deleteResource(final int id) {
		resourceDao.deleteResource(id);
	}

	public ResourceVo ResourcesDetails(String pJobCode) {
		ResourceVo resourceVo =resourceDao.getResourceDetails(pJobCode);
		return resourceVo;
	}

	public void addInterviewerToResource(String pJobCode , InterviwerVO interviewVo) {
		resourceDao.addInterviewerToResource(pJobCode, interviewVo);
	}


}
