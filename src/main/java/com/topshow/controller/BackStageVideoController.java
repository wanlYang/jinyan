package com.topshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topshow.entity.Result;
import com.topshow.entity.Video;
import com.topshow.service.VideoService;

/**
 * 视频控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/video")
public class BackStageVideoController {
	
	@Autowired
	private VideoService videoService;
	
	/**
	 * 获取video信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
    public Result getVideoList() {
        Result result = new Result();
        List<Video> videos = videoService.getAllVideo();
        result.setData(videos);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.videoService.getAllVideoCount());
        return result;
    }
	
	/**
	 * 获取所有数量
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/get/count",method = RequestMethod.GET)
    public Result getVideoCount() {
        Result result = new Result();
        result.setData(null);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.videoService.getAllVideoCount());
        return result;
    }
	
	/**
	 * 添加视频
	 * @param video
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/add/submit",method = RequestMethod.POST)
    public Result add(Video video) {
        Result result = null;
        result = videoService.addVideo(video);
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/delete/submit",method = RequestMethod.POST)
    public Result del(String id) {
        Result result = new Result();
        Integer row = videoService.del(id);
        result.setData(row);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("删除成功!");
        result.setCount(row);
        return result;
    }

}
