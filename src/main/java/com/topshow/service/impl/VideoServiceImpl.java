package com.topshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.topshow.entity.Result;
import com.topshow.entity.Video;
import com.topshow.mapper.VideoMapper;
import com.topshow.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public List<Video> getAllVideo() {
		return videoMapper.findAll();
	}

	@Override
	public Video getVideo(Integer id) {
		
		
		return videoMapper.findById(id);
	}

	@Override
	public Integer getAllVideoCount() {
		return videoMapper.findCount();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Result addVideo(Video video) {
		Integer row = videoMapper.create(video);
		
		return new Result(200, "添加成功", row, video);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer del(String id) {
		Video findById = videoMapper.findById(Integer.valueOf(id));
		String local = findById.getLocal();
		String video_img = findById.getVideo_img();
		String substring = local.substring(27);
		String substring_img = video_img.substring(27);
		String ACCESS_KEY = "C2b8fn4-lRQHc0XgTy98wsTXcOoHUqowVukDT6WQ";
        String SECRET_KEY = "1gMkVc99HlF9TDA1DJR9xjUm8D7uuswATml30m4Z";
        //要上传的空间
        String bucketname = "jinyanwudao";
	    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    //自动识别要上传的空间的初村区域是华东、华北、华南
	    Zone z = Zone.autoZone();
	    Configuration  c  = new Configuration(z);
	    BucketManager bucketManager = new  BucketManager(auth, c);
	    try {
			bucketManager.delete(bucketname, substring);
			bucketManager.delete(bucketname, substring_img);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoMapper.del(id);
	}
	public static void main(String[] args) {
		String a = "http://video.jytopshow.com/asdasd";
		System.out.println(a.substring(27));
	}
	

}
