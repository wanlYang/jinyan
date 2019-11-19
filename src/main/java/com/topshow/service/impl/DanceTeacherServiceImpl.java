package com.topshow.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshow.entity.DanceTeacher;
import com.topshow.entity.Result;
import com.topshow.entity.TeacherQueryParam;
import com.topshow.mapper.DanceTeacherMapper;
import com.topshow.service.DanceTeacherService;
import com.topshow.utils.FileUtils;
import com.topshow.utils.UUIDUtils;

/**
 * 舞蹈老师实现类
 * @author Administrator
 *
 */
@Service
public class DanceTeacherServiceImpl implements DanceTeacherService{

    @Autowired
    private DanceTeacherMapper danceTeacherMapper;
    
    /**
     * 获取所有导师
     */
    @Override
    public List<DanceTeacher> getAllDanceTeacher() {
        return danceTeacherMapper.findAllDanceTeacher();
    }
    /**
     * 后台获取所有导师内容根据关键字和分页
     */
    @Override
    public List<DanceTeacher> getAllDanceTeacherByPageAndKey(Integer page, Integer limit,
            TeacherQueryParam teacherQueryParam) {
        
        List<DanceTeacher> danceTeachers = null;
        if (page != null && limit != null) {
            danceTeachers = this.danceTeacherMapper.findAllTeacherListByPageAndKey(
                    Integer.valueOf((page.intValue() - 1) * limit.intValue()), limit, teacherQueryParam);
        }
        return (danceTeachers != null) ? danceTeachers : null;
    }
    /**
     * 获取所有老师根据分类和关键字获取数量
     * @param teacherQueryParam
     * @return
     */
    @Override
    public Integer getDanceTeacherCount(TeacherQueryParam teacherQueryParam) {
        Integer teacherCount = this.danceTeacherMapper.getTeacherCountByParam(teacherQueryParam);
        return Integer.valueOf((teacherCount != null) ? teacherCount.intValue() : 0);
    }
    
    /**
     * 添加导师
     */
    @Transactional(rollbackFor = { Exception.class })
    @Override
    public Result addTeacher(DanceTeacher danceTeacher) {
        if (danceTeacher == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        danceTeacher.setId(UUIDUtils.generateNumberUUID("DANCE_TEACHER_ID"));
        Integer row = danceTeacherMapper.creatTeacher(danceTeacher);
        return new Result(200,"添加成功!",row,danceTeacher);
    }
    
    /**
     * 编辑导师
     */
    @Transactional(rollbackFor = { Exception.class })
    @Override
    public Result editTeacher(DanceTeacher danceTeacher) {
        if (danceTeacher == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        Integer row = danceTeacherMapper.updateTeacher(danceTeacher);
        return new Result(200,"修改成功!",row,danceTeacher);
    }
    /**
     * 删除导师
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public Result delTeacher(String id,HttpServletRequest request) {
        
        if(!StringUtils.isNotBlank(id)) {
            return new Result(-2,"数据有误!",0,null);
        }
        DanceTeacher danceTeacher = danceTeacherMapper.getTeacherById(id);
        if (danceTeacher == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        Integer row = danceTeacherMapper.deleteTeacher(danceTeacher.getId());
        String rootPath = request.getServletContext().getRealPath("/");
        FileUtils.deleteFile(rootPath + danceTeacher.getImg());
        return new Result(200,"删除成功!",row,id);
    }
    
    /**
     * 根据ID获取舞蹈培训师
     */
    @Override
    public DanceTeacher getDanceTeacher(String id) {
        
        return danceTeacherMapper.getTeacherById(id);
    }
    /**
     * 获取所有导师数量
     */
	@Override
	public Integer getAllDanceTeacherCount() {
		return danceTeacherMapper.getAllCount();
	}
	@Override
	public List<DanceTeacher> getAllDanceTeacherByPage(Integer curr, Integer limit) {
		List<DanceTeacher> danceTeachers = null;
        if (curr != null && limit != null) {
            danceTeachers = this.danceTeacherMapper.findAllTeacherListByPage(
                    Integer.valueOf((curr.intValue() - 1) * limit.intValue()), limit);
        }
        return (danceTeachers != null) ? danceTeachers : null;
	}
    
    
    
}
