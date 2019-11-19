package com.topshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshow.entity.Suggestion;
import com.topshow.mapper.SuggestionMapper;
import com.topshow.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService{
	
	@Autowired
	private SuggestionMapper suggestionMapper;

	@Override
	public Integer create(Suggestion suggestion) {
		return suggestionMapper.create(suggestion);
	}

	@Override
	public List<Suggestion> getAllSuggestionByPage(Integer page, Integer limit) {
		List<Suggestion> suggestions = null;
        if (page != null && limit != null) {
        	suggestions = this.suggestionMapper.findAllSuggestionByPage(
                    Integer.valueOf((page.intValue() - 1) * limit.intValue()), limit);
        }
        return (suggestions != null) ? suggestions : null;
	}

	@Override
	public Integer getSuggestionCount() {
		return suggestionMapper.findCount();
	}

	/**
	 * 删除
	 */
	@Override
	public Integer del(String id) {
		
		
		return suggestionMapper.delete(id);
	}

}
