package com.topshow.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.topshow.entity.News;
import com.topshow.entity.Result;
import com.topshow.service.TopNewsService;

@Controller
@RequestMapping("/admin/news")
public class BackStageNewsController {
	
	/**
	 * 获取新闻列表
	 */
	@Autowired
	private TopNewsService topNewsService;
	@ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
    public Result getNewsList(Integer page, Integer limit) {
        Result result = new Result();
        List<News> news = topNewsService.getAllNewsByPage(page, limit);
        result.setData(news);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.topNewsService.getNewsCount());
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Result getNews() {
        Result result = new Result();
        List<News> news = topNewsService.getAllTopNews();
        result.setData(news);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.topNewsService.getNewsCount());
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/get/count",method = RequestMethod.GET)
    public Result getCount() {
        Result result = new Result();
        result.setData(null);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.topNewsService.getNewsCount());
        return result;
    }
	
	/**
	 * 添加新闻
	 * @param news
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/add/submit",method = RequestMethod.POST)
    public Result add(News news) {
        Result result = null;
        result = topNewsService.addNews(news);
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/edit/submit",method = RequestMethod.POST)
    public Result edit(News news) {
		System.out.println(news);
        Result result = null;
        result = topNewsService.editNews(news);
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/del/submit",method = RequestMethod.POST)
    public Result del(String id) {
        Result result = null;
        result = topNewsService.delNews(id);
        return result;
    }
	/**
	 * 
	 * @param request
	 * @param file
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
    @RequestMapping(value = { "/upload/img" }, method = { RequestMethod.POST })
    public Map<String, Object> changeImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,HttpSession session)
            throws IllegalStateException, IOException {
	    Map<String, Object> map = new HashMap<String, Object>();
	    Result changeImgFunction = changeImgFunction(request,file,0);
        map.put("code", Integer.valueOf(0));
        map.put("msg", "上传成功!");
        Map<String, Object> mapData = new HashMap<String, Object>();
        String fileName = (String)changeImgFunction.getData();
        mapData.put("src", request.getContextPath() + fileName.split(",")[0]);
        mapData.put("title", fileName.split(",")[1]);
        mapData.put("src_save", fileName.split(",")[0]);
        map.put("data", mapData);
        return map;
    }
	
	@ResponseBody
    @RequestMapping(value = { "/upload/content/img" }, method = { RequestMethod.POST })
    public Map<String, Object> changeImgContent(HttpServletRequest request, @RequestParam("upload_file") MultipartFile file,HttpSession session)
            throws IllegalStateException, IOException {
        Result changeImgFunction = changeImgFunction(request,file,1);
        Map<String, Object> map_data = new HashMap<String, Object>();
        map_data.put("success", Boolean.valueOf(true));
        map_data.put("msg", "上传成功!");
        String url = (String)changeImgFunction.getData();
        map_data.put("file_path",url.split(",")[0]);
        map_data.put("title", url.split(",")[1]);
        return map_data;
    }
	
    public Result changeImgFunction(HttpServletRequest request, MultipartFile file,Integer url)
            throws IllegalStateException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String rootPath = request.getServletContext().getRealPath("/admin/uploads/");
        String res = sdf.format(new Date());
        String originalFilename = file.getOriginalFilename();
        String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));
        File newFile = new File(rootPath + File.separator + "news" + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newFile);
            if (url.intValue() == 1) {
                String fileUrl = "/admin/uploads/news/"+newFileName;
                return new Result(200, "上传成功!", 0, request.getScheme() + "://" + request.getServerName() + request.getContextPath() + fileUrl +"," + newFileName);
            }
            String fileUrl = "/admin/uploads/news/" + newFileName;
            return new Result(200, "上传成功!", 0, fileUrl + "," + newFileName);
        } catch (Exception e) {
            return null;
        }
    }

}
