package com.topshow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.topshow.entity.DanceTeacher;
import com.topshow.entity.TeacherQueryParam;

/**
 * 舞蹈培训书数据库相关操作
 * @author Administrator
 *
 */
@Repository
public interface DanceTeacherMapper {
    
    /**
     * 获取所有舞蹈培训师
     * @return
     */
    List<DanceTeacher> findAllDanceTeacher();

    /**
     * 后台获取所有导师根据关键字和分页
     * @param valueOf
     * @param limit
     * @param teacherQueryParam
     * @return
     */
    List<DanceTeacher> findAllTeacherListByPageAndKey(@Param("start")Integer start, @Param("limit")Integer limit,
            TeacherQueryParam teacherQueryParam);

    /**
     * 后台获取所有导师根据关键字和分页数量
     * @param teacherQueryParam
     * @return
     */
    Integer getTeacherCountByParam(TeacherQueryParam teacherQueryParam);

    /**
     * 添加导师
     * @param danceTeacher
     * @return
     */
    Integer creatTeacher(DanceTeacher danceTeacher);

    /**
     * 编辑导师
     * @param danceTeacher
     * @return
     */
    Integer updateTeacher(DanceTeacher danceTeacher);

    /**
     * 删除导师
     * @param id
     * @return
     */
    Integer deleteTeacher(String id);

    /**
     * 根据ID获取导师
     * @param id
     * @return
     */
    DanceTeacher getTeacherById(String id);

    /**
     * 获取所有数量
     * @return
     */
	Integer getAllCount();

	/**
	 * 前端获取分页数据
	 * @param valueOf
	 * @param limit
	 * @return
	 */
	List<DanceTeacher> findAllTeacherListByPage(@Param("start")Integer start, @Param("limit")Integer limit);
    

}
