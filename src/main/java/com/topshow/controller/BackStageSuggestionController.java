package com.topshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.topshow.entity.Result;
import com.topshow.entity.Suggestion;
import com.topshow.service.SuggestionService;

@Controller
@RequestMapping("/admin/suggestion")
public class BackStageSuggestionController {
	
	@Autowired
	private SuggestionService suggestionService;
	
	@ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
	public Result getSuggestionList(Integer page, Integer limit) {
        Result result = new Result();
        List<Suggestion> suggestions = suggestionService.getAllSuggestionByPage(page, limit);
        result.setData(suggestions);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.suggestionService.getSuggestionCount());
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/get/count",method = RequestMethod.GET)
	public Result getCount() {
        Result result = new Result();
        result.setData(null);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.suggestionService.getSuggestionCount());
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/delete/submit",method = RequestMethod.POST)
	public Result del(String id) {
        Result result = new Result();
        Integer row = suggestionService.del(id);
        result.setData(row);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("删除成功!");
        result.setCount(row);
        return result;
    }
}
