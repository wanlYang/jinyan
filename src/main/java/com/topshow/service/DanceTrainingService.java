package com.topshow.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.topshow.entity.DanceTraining;
import com.topshow.entity.Result;

/**
 * 培训舞蹈项目服务层
 * @author Administrator
 *
 */
public interface DanceTrainingService {

    /**
     * 获取所有培训项目
     * @return
     */
    List<DanceTraining> getAllDanceTraining();

    /**
     * 后台获取所有培训项目根据分页数据
     * @param page
     * @param limit
     * @return
     */
    List<DanceTraining> getAllDanceTrainingByPage(Integer page, Integer limit);

    /**
     * 获取全部数量
     * @return
     */
    Integer getDanceTrainingCount();

    /**
     * 添加项目
     * @param danceTraining
     * @return
     */
    Result addTraining(DanceTraining danceTraining);
    /**
     * 编辑训练项目
     * @param danceTraining
     * @return
     */
    Result editTraining(DanceTraining danceTraining);

    /**
     * 删除项目
     * @param id
     * @param request
     * @return
     */
    Result delTraining(String id, HttpServletRequest request);

    /**
     * 根据ID获取
     * @param id
     * @return
     */
	DanceTraining getDanceTraining(String id);
    
}
