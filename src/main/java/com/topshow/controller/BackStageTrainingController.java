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

import com.topshow.entity.DanceTraining;
import com.topshow.entity.Result;
import com.topshow.service.DanceTrainingService;
import com.topshow.utils.FileUtils;

/**
 * 后台舞蹈培训项目相关操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/training")
public class BackStageTrainingController {
    
    @Autowired
    private DanceTrainingService danceTrainingService;
    
    /**
     * 获取项目
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/list",method = RequestMethod.POST)
    public Result getTeacherList(Integer page, Integer limit) {
        Result result = new Result();
        List<DanceTraining> danceTrainings = danceTrainingService.getAllDanceTrainingByPage(page, limit);
        result.setData(danceTrainings);
        result.setStatus(Integer.valueOf(200));
        result.setMessage("获取成功!");
        result.setCount(this.danceTrainingService.getDanceTrainingCount());
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
        result.setCount(this.danceTrainingService.getDanceTrainingCount());
        return result;
    }
    /**
     * 添加培训项目
     * @param danceTraining
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add/submit",method = RequestMethod.POST)
    public Result add(DanceTraining danceTraining,HttpSession session) {
        Result result = null;
        String img = (String) session.getAttribute("addTrainingTempImgLocal");
        session.removeAttribute("addTrainingTempImgLocal");
        if (!StringUtils.isNotBlank(img)) {
            return new Result(-2,"简图信息失效!",0,null);
        }
        danceTraining.setDanceImg(img);
        result = danceTrainingService.addTraining(danceTraining);
        return result;
    }
    /**
     * 修改项目
     * @param danceTraining
     * @param imgtext
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit/submit",method = RequestMethod.POST)
    public Result edit(DanceTraining danceTraining,String imgtext,HttpSession session,HttpServletRequest request) {
        Result result = null;
        String img = (String) session.getAttribute("addTrainingTempImgLocal");
        session.removeAttribute("addTrainingTempImgLocal");
        if (StringUtils.isNotBlank(img)) {
            String rootPath = request.getServletContext().getRealPath("/");
            FileUtils.deleteFile(rootPath + imgtext);
        }
        danceTraining.setDanceImg(img);
        result = danceTrainingService.editTraining(danceTraining);
        return result;
    }
    
    /**
     * 删除
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/submit",method = RequestMethod.POST)
    public Result delete(String id,HttpServletRequest request) {
        return danceTrainingService.delTraining(id,request);
    }
    /**
     * 舞蹈简图上传
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
        File newFile = new File(rootPath + File.separator + "training" + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        String fileUrl = "/admin/uploads/training/" + newFileName;

        Map<String, Object> map = new HashMap<String, Object>();

        session.setAttribute("addTrainingTempImgLocal", fileUrl);
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
