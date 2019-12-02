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

import com.topshow.entity.Cources;
import com.topshow.entity.Result;
import com.topshow.service.CourcesService;

@Controller
@RequestMapping("/admin/cources")
public class BackStageCourcesController {
	
	@Autowired
	private CourcesService courcesService;
	
	/**
	 * 获取列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
    public Result getBannerList() {
        Result result = new Result();
        List<Cources> cources = courcesService.getAllCources();
        result.setData(cources);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.courcesService.getAllCourcesCount());
        return result;
    }
	
	@ResponseBody
    @RequestMapping(value = "/delete/submit",method = RequestMethod.POST)
    public Result del(Integer id) {
        Result result = new Result();
        Integer row = courcesService.del(id);
        result.setData(row);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("删除成功!");
        result.setCount(id);
        return result;
    }
	
	/**
	 * 添加课程表
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String rootPath = request.getServletContext().getRealPath("/admin/uploads");
        String res = sdf.format(new Date());
        String originalFilename = file.getOriginalFilename();
        String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));
        File newFile = new File(rootPath + File.separator + "cources"  + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        String fileUrl = "/admin/uploads/cources/" + newFileName;

        Map<String, Object> map = new HashMap<String, Object>();
        Cources cources = new Cources();
        cources.setTableImg(fileUrl);
        this.courcesService.addTableImg(cources);
        map.put("code", Integer.valueOf(0));
        map.put("msg", "上传成功!");
        Map<String, Object> mapData = new HashMap<String, Object>();
        mapData.put("src", request.getContextPath() + fileUrl);
        mapData.put("title", newFileName);
        map.put("data", mapData);
        return map;
    }

}
