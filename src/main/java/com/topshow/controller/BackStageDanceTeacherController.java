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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.topshow.entity.DanceTeacher;
import com.topshow.entity.Result;
import com.topshow.entity.TeacherQueryParam;
import com.topshow.service.DanceTeacherService;
import com.topshow.utils.FileUtils;

/**
 * 舞蹈老师相关操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/teacher")
public class BackStageDanceTeacherController {
    
    @Autowired
    private DanceTeacherService danceTeacherService;

    /**
     * 后台获取所有导师列表
     * @param page
     * @param limit
     * @param teacherQueryParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
    public Result getTeacherList(Integer page, Integer limit, TeacherQueryParam teacherQueryParam) {
        Result result = new Result();
        List<DanceTeacher> danceTeachers = danceTeacherService.getAllDanceTeacherByPageAndKey(page, limit, teacherQueryParam);
        result.setData(danceTeachers);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.danceTeacherService.getDanceTeacherCount(teacherQueryParam));
        return result;
    }
    
    /**
     * 获取所有数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/count",method = RequestMethod.GET)
    public Result getCount() {
        Result result = new Result();
        result.setData(null);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.danceTeacherService.getAllDanceTeacherCount());
        return result;
    }
    
    /**
     * 添加导师提交
     * @param danceTeacher
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add/submit",method = RequestMethod.POST)
    public Result add(DanceTeacher danceTeacher,HttpSession session) {
        Result result = null;
        String img = (String) session.getAttribute("addTeacherTempImgLocal");
        session.removeAttribute("addTeacherTempImgLocal");
        if (!StringUtils.isNotBlank(img)) {
            return new Result(-2,"简图信息失效!",0,null);
        }
        danceTeacher.setImg(img);
        result = danceTeacherService.addTeacher(danceTeacher);
        return result;
    }
    
    /**
     * 编辑导师提交
     * @param danceTeacher
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit/submit",method = RequestMethod.POST)
    public Result edit(DanceTeacher danceTeacher,String imgtext,HttpSession session,HttpServletRequest request) {
        Result result = null;
        String img = (String) session.getAttribute("addTeacherTempImgLocal");
        session.removeAttribute("addTeacherTempImgLocal");
        if (StringUtils.isNotBlank(img)) {
            String rootPath = request.getServletContext().getRealPath("/");
            FileUtils.deleteFile(rootPath + imgtext);
        }
        danceTeacher.setImg(img);
        result = danceTeacherService.editTeacher(danceTeacher);
        return result;
    }
    /**
     * 删除导师
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/submit",method = RequestMethod.POST)
    public Result delete(String id,HttpServletRequest request) {
        
        return danceTeacherService.delTeacher(id,request);
    }
    
    /**
     * 导师简图上传
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
        String rootPath = request.getServletContext().getRealPath("/admin/uploads/");
        String res = sdf.format(new Date());
        String originalFilename = file.getOriginalFilename();
        String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));
        File newFile = new File(rootPath + File.separator + "teacher" + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        String fileUrl = "/admin/uploads/teacher/" + newFileName;

        Map<String, Object> map = new HashMap<String, Object>();

        session.setAttribute("addTeacherTempImgLocal", fileUrl);
        //Integer updateTeacherHeadImg = this.danceTeacherService.updateTeacherHeadImg(fileUrl, user.getId());
        map.put("code", Integer.valueOf(0));
        map.put("msg", "上传成功!");
        Map<String, Object> mapData = new HashMap<String, Object>();
        mapData.put("src", request.getContextPath() + fileUrl);
        mapData.put("title", newFileName);
        map.put("data", mapData);
        return map;
    }
}
