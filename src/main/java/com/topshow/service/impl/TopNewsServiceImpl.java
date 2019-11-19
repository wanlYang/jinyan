package com.topshow.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshow.entity.News;
import com.topshow.entity.Result;
import com.topshow.mapper.TopNewsMapper;
import com.topshow.service.TopNewsService;

@Service
public class TopNewsServiceImpl implements TopNewsService{
	
	@Autowired
	private TopNewsMapper topNewsMapper;
	@Override
	public List<News> getAllTopNews() {
		List<News> list = topNewsMapper.getAllNews();
		
		return list;
	}
	@Override
	public List<News> getAllNewsByPage(Integer page, Integer limit) {
		 List<News> news = null;
	        if (page != null && limit != null) {
	        	news = this.topNewsMapper.findAllNewsByPage(
	                    Integer.valueOf((page.intValue() - 1) * limit.intValue()), limit);
	        }
	        return (news != null) ? news : null;
	}
	@Override
	public Integer getNewsCount() {
		return topNewsMapper.findCount();
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Result addNews(News news) {
		if (news.getBrowse_volume() == null) {
			news.setBrowse_volume(0);
		}
		news.setRelease_time(new Date());
		Integer row = topNewsMapper.create(news);
		return new Result(200,"添加成功!",row,news);
	}
	@Override
	public Result delNews(String id) {
		Integer row = topNewsMapper.delete(Integer.valueOf(id));
		
		return new Result(200,"删除成功!",row,id);
	}
	@Override
	public Result editNews(News news) {
		
		Integer row = topNewsMapper.update(news);
		
		return new Result(200,"修改成功!",row,news);
	}
	@Override
	public News getNews(String id) {
		return topNewsMapper.findNewsById(Integer.valueOf(id));
	}
	
	

}
