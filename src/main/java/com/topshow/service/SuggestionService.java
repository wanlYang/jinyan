package com.topshow.service;

import java.util.List;

import com.topshow.entity.Suggestion;

public interface SuggestionService {

	Integer create(Suggestion suggestion);

	/**
	 * 获取所有留言
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Suggestion> getAllSuggestionByPage(Integer page, Integer limit);

	/**
	 * 获取数量
	 * @return
	 */
	Integer getSuggestionCount();

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer del(String id);
	
	

}
