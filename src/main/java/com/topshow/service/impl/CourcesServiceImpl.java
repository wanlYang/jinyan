package com.topshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshow.entity.Cources;
import com.topshow.mapper.CourcesMapper;
import com.topshow.service.CourcesService;

@Service
public class CourcesServiceImpl implements CourcesService{

	@Autowired
	private CourcesMapper courcesMapper;
	
	@Override
	public List<Cources> getAllCources() {
		return courcesMapper.findAll();
	}

	@Override
	public Integer getAllCourcesCount() {
		// TODO Auto-generated method stub
		return courcesMapper.findAllCount();
	}

	@Override
	public void addTableImg(Cources cources) {
		courcesMapper.create(cources);
	}

	@Override
	public Integer del(Integer id) {
		// TODO Auto-generated method stub
		return courcesMapper.del(String.valueOf(id));
	}
	
	

}
