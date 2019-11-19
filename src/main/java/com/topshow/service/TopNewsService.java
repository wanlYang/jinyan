package com.topshow.service;

import java.util.List;

import com.topshow.entity.News;
import com.topshow.entity.Result;

/**
 * 企业新闻
 * @author Administrator
 *
 */
public interface TopNewsService {

	List<News> getAllTopNews();

	/**
	 * 获取所有新闻根据分页
	 * @param page
	 * @param limit
	 * @return
	 */
	List<News> getAllNewsByPage(Integer page, Integer limit);

	/**
	 * 获取数量
	 * @return
	 */
	Integer getNewsCount();

	/**
	 * 添加新闻
	 * @param news
	 * @return
	 */
	Result addNews(News news);

	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	Result delNews(String id);

	/**
	 * 修改新闻
	 * @param news
	 * @return
	 */
	Result editNews(News news);

	/**
	 * 获取新闻
	 * @param id
	 * @return
	 */
	News getNews(String id);

	
	

}
