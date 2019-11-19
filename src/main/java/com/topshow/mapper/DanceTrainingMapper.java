package com.topshow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.topshow.entity.DanceTraining;

/**
 * 舞蹈培训项目数据库操作
 * @author Administrator
 *
 */
@Repository
public interface DanceTrainingMapper {
    
    /**
     * 获取所有培训项目
     * @return
     */
    List<DanceTraining> findAllDanceTraining();
    /**
     * 后台获取所有培训项目根据分页
     * @param valueOf
     * @param limit
     * @return
     */
    List<DanceTraining> findAllDanceTrainingByPage(@Param("start")Integer start, @Param("limit")Integer limit);
    /**
     * 后台获取所有培训项目分页数量
     * @param teacherQueryParam
     * @return
     */
    Integer getTrainingCount();
    /**
     * 添加项目
     * @param danceTraining
     * @return
     */
    Integer creatTraining(DanceTraining danceTraining);
    /**
     * 修改
     * @param danceTraining
     * @return
     */
    Integer updateTraining(DanceTraining danceTraining);
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    DanceTraining getTrainingById(String id);
    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteTraining(String id);
}
