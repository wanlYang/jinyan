package com.topshow.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.topshow.entity.Cources;

@Repository
public interface CourcesMapper {

	List<Cources> findAll();

	Integer findAllCount();

	Integer create(Cources cources);
	
	Integer del(String id);

}
