package com.topshow.service;

import java.util.List;

import com.topshow.entity.Cources;

public interface CourcesService {

	List<Cources> getAllCources();

	Integer getAllCourcesCount();

	void addTableImg(Cources cources);

	Integer del(Integer id);

}
