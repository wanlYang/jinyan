package com.topshow.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.topshow.entity.DanceTeacher;
import com.topshow.entity.Result;
import com.topshow.entity.TeacherQueryParam;

/**
 * 主页修改舞蹈老师相关信息服务层
 * @author Administrator
 *
 */
public interface DanceTeacherService {

    /**
     * 获取所有舞蹈培训师
     * @return
     */
    List<DanceTeacher> getAllDanceTeacher();

    /**
     * 获取所有老师根据分类和关键字
     * @param page
     * @param limit
     * @param userQueryParam
     * @return
     */
    List<DanceTeacher> getAllDanceTeacherByPageAndKey(Integer page, Integer limit, TeacherQueryParam teacherQueryParam);

    /**
     * 获取所有老师根据分类和关键字获取数量
     * @param teacherQueryParam
     * @return
     */
    Integer getDanceTeacherCount(TeacherQueryParam teacherQueryParam);

    /**
     * 添加导师
     * @param danceTeacher
     * @return
     */
    Result addTeacher(DanceTeacher danceTeacher);

    /**
     * 编辑导师
     * @param danceTeacher
     * @return
     */
    Result editTeacher(DanceTeacher danceTeacher);

    /**
     * 删除导师
     * @param id
     * @return
     */
    Result delTeacher(String id,HttpServletRequest request);

    /**
     * 根据ID获取导师
     * @param id
     * @return
     */
    DanceTeacher getDanceTeacher(String id);

    /**
     * 获取所有导师数量
     * @return
     */
	Integer getAllDanceTeacherCount();

	/**
	 * 前端导师分页数据
	 * @param curr
	 * @param limit
	 * @return
	 */
	List<DanceTeacher> getAllDanceTeacherByPage(Integer curr, Integer limit);

   
    
}
