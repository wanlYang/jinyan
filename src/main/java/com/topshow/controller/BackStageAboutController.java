package com.topshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topshow.entity.About;
import com.topshow.entity.Result;
import com.topshow.service.AboutService;

/**
 * 前台关于
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/about")
public class BackStageAboutController {
	
	@Autowired
	private AboutService aboutService;
	
	@RequestMapping(value = "/get",method = RequestMethod.POST)
	@ResponseBody
    public Result about(String id) {
		Result result = new Result();
    	About about = aboutService.getAbout();
    	result.setData(about);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(Integer.valueOf(id));        
        return result;
    }
	
	@RequestMapping(value = "/edit/submit",method = RequestMethod.POST)
	@ResponseBody
    public Result edit(About about) {
		Result result = new Result();
    	Integer row = aboutService.editAbout(about);
    	result.setData(about);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("修改成功!");
        result.setCount(row);        
        return result;
    }

}
