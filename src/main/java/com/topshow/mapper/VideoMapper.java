package com.topshow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.topshow.entity.Video;

@Repository
public interface VideoMapper {

	List<Video> findAll();

	Video findById(Integer id);

	Integer findCount();

	Integer create(Video video);

	Integer del(String id);

	List<Video> findAllVideoByPage(@Param("start")Integer start, @Param("limit")Integer limit);

}
