package com.topshow.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.topshow.entity.About;
import com.topshow.entity.Cources;
import com.topshow.entity.DanceTeacher;
import com.topshow.entity.DanceTraining;
import com.topshow.entity.News;
import com.topshow.entity.Result;
import com.topshow.entity.Video;
import com.topshow.service.AboutService;
import com.topshow.service.CourcesService;
import com.topshow.service.DanceTeacherService;
import com.topshow.service.DanceTrainingService;
import com.topshow.service.VideoService;
import com.topshow.service.TopNewsService;

/**
 * 视图控制器
 * @author TOP SHOW YANG
 * 
 */
@Controller
public class ViewController {
    
    @Autowired
    private DanceTeacherService danceTeacherService;
    @Autowired
    private DanceTrainingService danceTrainingService;
    
    @Autowired
    private CourcesService courcesService;
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private AboutService aboutService;
    
    @Autowired
    private TopNewsService topNewsService;
    
    /**
     * 新晔导师页面跳转
     */
    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public ModelAndView teacher(ModelAndView modelAndView) {
		/*
		 * List<DanceTeacher> allDanceTeacher =
		 * danceTeacherService.getAllDanceTeacher();
		 * modelAndView.addObject("allDanceTeacher",allDanceTeacher);
		 */
    	modelAndView.setViewName("category-teacher");
        return modelAndView;
    }
    
    /**
     * 新晔导师页面跳转根据分页
     * @param curr
     * @param limit
     * @return
     */
    @RequestMapping(value = "/teacher/page",method = RequestMethod.POST)
    @ResponseBody
    public Result teachePage(Integer curr,Integer limit) {
    	Result result = new Result();
    	List<DanceTeacher> allDanceTeacher = danceTeacherService.getAllDanceTeacherByPage(curr, limit);
    	result.setStatus(200);
    	result.setData(allDanceTeacher);
    	result.setCount(danceTeacherService.getAllDanceTeacherCount());
    	result.setMessage("获取成功!");
        return result;
    }
    
    /**
     * 新晔导师获取数量
     * @param curr
     * @param limit
     * @return
     */
    @RequestMapping(value = "/teacher/count",method = RequestMethod.GET)
    @ResponseBody
    public Result teacheCount() {
    	Result result = new Result();
    	result.setStatus(200);
    	result.setData(null);
    	result.setCount(danceTeacherService.getAllDanceTeacherCount());
    	result.setMessage("获取成功!");
        return result;
    }
    
    /**
     * 新晔项目培训跳转
     */
    @RequestMapping(value = "/species",method = RequestMethod.GET)
    public ModelAndView species(ModelAndView modelAndView) {
		/*
		 * List<DanceTraining> allDanceTraining =
		 * danceTrainingService.getAllDanceTraining();
		 * modelAndView.addObject("allDanceTraining",allDanceTraining);
		 */    	
    	modelAndView.setViewName("category-species");
        return modelAndView;
    }
    
    /**
     * 新晔项目培训跳转分页数据
     * @param curr
     * @param limit
     * @return
     */
    @RequestMapping(value = "/species/page",method = RequestMethod.POST)
    @ResponseBody
    public Result speciesPage(Integer curr,Integer limit) {
    	Result result = new Result();
    	List<DanceTraining> allDanceTraining = danceTrainingService.getAllDanceTrainingByPage(curr,limit);
    	result.setStatus(200);
    	result.setData(allDanceTraining);
    	result.setCount(danceTrainingService.getDanceTrainingCount());
    	result.setMessage("获取成功!");
        return result;
    }
    
    /**
     * 新晔项目培训数量
     * @return
     */
    @RequestMapping(value = "/species/count",method = RequestMethod.GET)
    @ResponseBody
    public Result speciesCount() {
    	Result result = new Result();
    	result.setStatus(200);
    	result.setData(null);
    	result.setCount(danceTrainingService.getDanceTrainingCount());
    	result.setMessage("获取成功!");
        return result;
    }
    /**
     * 跳转视频集锦页面
     */
    @RequestMapping(value = "/vts",method = RequestMethod.GET)
    public ModelAndView videoHighlights(ModelAndView modelAndView) {
    	List<Video> list = videoService.getAllVideo();
    	modelAndView.addObject("videos",list);
    	modelAndView.setViewName("category-video");
        return modelAndView;
    }

    /**
     * 跳转新晔课程页面
     */
    @RequestMapping(value = "/cources",method = RequestMethod.GET)
    public ModelAndView cources(ModelAndView modelAndView) {
    	List<Cources> list = courcesService.getAllCources();
    	modelAndView.addObject("cources",list);
    	modelAndView.setViewName("cources");
        return modelAndView;
    }
    
    /**
     * 跳转企业新闻页面
     * @return
     */
    @RequestMapping(value = "/topnews",method = RequestMethod.GET)
    public ModelAndView topnews(ModelAndView modelAndView) {
    	List<News> news = topNewsService.getAllTopNews();
    	modelAndView.addObject("news",news);
    	modelAndView.setViewName("category-news");
        return modelAndView;
    }
    
    /**
     * 跳转关于我们页面
     * @return
     */
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView about(ModelAndView modelAndView) {
    	About about = aboutService.getAbout();
    	modelAndView.addObject("about",about);
    	modelAndView.setViewName("about");
        
        return modelAndView;
    }
    
    /**
     * 跳转意见反馈页面
     * @return
     */
    @RequestMapping(value = "/suggestion",method = RequestMethod.GET)
    public String suggestion() {
        
        
        return "suggestion";
    }
    
    /**
     * 跳转联系我们页面
     * @return
     */
    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contact() {
        
        
        return "contact";
    }
    
    /**
     * 跳转舞蹈培训师详细页面
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/teacher/detail/{id}",method = RequestMethod.GET)
    public ModelAndView showTeacher(@PathVariable("id") String id,ModelAndView modelAndView) {
        if (!StringUtils.isNotBlank(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        DanceTeacher danceTeacher = danceTeacherService.getDanceTeacher(id);
        modelAndView.setViewName("show-teacher");
        modelAndView.addObject("danceTeacher", danceTeacher);
        return modelAndView;
    }
    
    /**
     * 跳转培训项目详细页面
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/training/detail/{id}",method = RequestMethod.GET)
    public ModelAndView showTraining(@PathVariable("id") String id,ModelAndView modelAndView) {
        if (!StringUtils.isNotBlank(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        DanceTraining danceTraining = danceTrainingService.getDanceTraining(id);
        modelAndView.setViewName("show-species");
        modelAndView.addObject("danceTraining", danceTraining);
        return modelAndView;
    }
    
    /**
     * 新闻详情页面
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/news/detail/{id}",method = RequestMethod.GET)
    public ModelAndView showNews(@PathVariable("id") String id,ModelAndView modelAndView) {
        if (!StringUtils.isNotBlank(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        News news = topNewsService.getNews(id);
        modelAndView.setViewName("show-news");
        modelAndView.addObject("news", news);
        List<News> newsList = topNewsService.getAllTopNews();
    	modelAndView.addObject("news_t",newsList);
        return modelAndView;
    }
    
    /**
     * 视频详情页面
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/video/detail/{id}",method = RequestMethod.GET)
    public ModelAndView video(@PathVariable("id") Integer id,ModelAndView modelAndView) {
        Video video = videoService.getVideo(id);
        modelAndView.setViewName("show-video");
        modelAndView.addObject("video", video);
        return modelAndView;
    }
}
