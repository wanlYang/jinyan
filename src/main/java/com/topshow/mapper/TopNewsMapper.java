package com.topshow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.topshow.entity.News;

@Repository
public interface TopNewsMapper {

	List<News> getAllNews();

	List<News> findAllNewsByPage(@Param("start")Integer start, @Param("limit")Integer limit);
	
	Integer findCount();

	Integer create(News news);

	Integer delete(Integer id);

	Integer update(News news);

	News findNewsById(Integer id);

	List<News> findNews();

}
