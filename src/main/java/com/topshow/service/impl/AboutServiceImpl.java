package com.topshow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshow.entity.About;
import com.topshow.mapper.AboutMapper;
import com.topshow.service.AboutService;

@Service
public class AboutServiceImpl implements AboutService{

	@Autowired
	private AboutMapper aboutMapper;
	
	@Override
	public About getAbout() {
		
		
		return aboutMapper.getAbout(1);
	}

	@Override
	public Integer editAbout(About about) {
		// TODO Auto-generated method stub
		about.setId(1);
		return aboutMapper.update(about);
	}
	
	

}
