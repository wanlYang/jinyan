package com.topshow.service;

import java.util.List;

import com.topshow.entity.Result;
import com.topshow.entity.Video;

public interface VideoService {

	List<Video> getAllVideo();

	Video getVideo(Integer id);

	Integer getAllVideoCount();

	Result addVideo(Video video);

	Integer del(String id);

	List<Video> getAllVideo(Integer curr, Integer limit);
	
	

}
