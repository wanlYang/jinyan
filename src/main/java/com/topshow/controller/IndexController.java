package com.topshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.topshow.entity.Banner;
import com.topshow.entity.DanceTeacher;
import com.topshow.entity.DanceTraining;
import com.topshow.entity.News;
import com.topshow.service.BannerService;
import com.topshow.service.DanceTeacherService;
import com.topshow.service.DanceTrainingService;
import com.topshow.service.TopNewsService;

/**
 * 首页控制器
 * @author Administrator
 *
 */
@Controller
public class IndexController {

    @Autowired
    private DanceTeacherService danceTeacherService;
    
    @Autowired
    private DanceTrainingService danceTrainingService;
    
    @Autowired
    private BannerService bannerService;
    
    @Autowired
    private TopNewsService topNewsService;
    
    /**
     * 默认首页面跳转
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        //获取舞蹈培训师信息
        List<DanceTeacher> danceTeachers = danceTeacherService.getAllDanceTeacher();
        modelAndView.addObject("danceTeachers", danceTeachers.size()<=6?danceTeachers:danceTeachers.subList(0, 6));
        //获取培训项目信息
        List<DanceTraining> danceTrainings = danceTrainingService.getAllDanceTraining();
        modelAndView.addObject("danceTrainings", danceTrainings.size()<=6?danceTrainings:danceTrainings.subList(0, 6));
        //获取banner信息
        List<Banner> banners = bannerService.getAllBanner();
        modelAndView.addObject("banners", banners);
        //获取最新消息
        List<News> newsList = topNewsService.getAllTopNews();
    	modelAndView.addObject("news_t",newsList.size()<=6?newsList:newsList.subList(0, 6));
        
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    @RequestMapping(value = "/wap",method = RequestMethod.GET)
    public ModelAndView wap(ModelAndView modelAndView) {
    	//获取舞蹈培训师信息
        List<DanceTeacher> danceTeachers = danceTeacherService.getAllDanceTeacher();
        modelAndView.addObject("danceTeachers", danceTeachers.size()<=6?danceTeachers:danceTeachers.subList(0, 6));
        //获取培训项目信息
        List<DanceTraining> danceTrainings = danceTrainingService.getAllDanceTraining();
        modelAndView.addObject("danceTrainings", danceTrainings.size()<=6?danceTrainings:danceTrainings.subList(0, 6));
        //获取banner信息
        List<Banner> banners = bannerService.getAllBanner();
        modelAndView.addObject("banners", banners);
        //获取最新消息
        List<News> newsList = topNewsService.getAllTopNews();
    	modelAndView.addObject("news_t",newsList.size()<=6?newsList:newsList.subList(0, 6));
        
        modelAndView.setViewName("wap");
        return modelAndView;
    }
   
    
    
}
