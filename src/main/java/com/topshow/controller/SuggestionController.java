package com.topshow.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.topshow.entity.Suggestion;
import com.topshow.service.SuggestionService;
import com.topshow.utils.RegexUtils;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {
	
	@Autowired
	private SuggestionService suggestionService;
	
	@RequestMapping("/submit")
	public ModelAndView add(ModelAndView modelAndView,Suggestion suggestion) {
		if(suggestion == null || !StringUtils.isNoneBlank(suggestion.getContent()) || !RegexUtils.checkPhone(suggestion.getPhone())) {
			modelAndView.setViewName("suggestion");
			modelAndView.addObject("message", "留言失败!请检查信息!");
			return modelAndView;
		}
		suggestionService.create(suggestion);
		modelAndView.setViewName("suggestion");
		modelAndView.addObject("message", "留言成功!");
		return modelAndView;
	}

}
