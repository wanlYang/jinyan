package com.topshow.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshow.entity.DanceTraining;
import com.topshow.entity.Result;
import com.topshow.mapper.DanceTrainingMapper;
import com.topshow.service.DanceTrainingService;
import com.topshow.utils.FileUtils;
import com.topshow.utils.UUIDUtils;

/**
 * 培训舞蹈项目服务层实现类
 * @author Administrator
 *
 */
@Service
public class DanceTrainingServiceImpl implements DanceTrainingService{

    @Autowired
    private DanceTrainingMapper danceTrainingMapper;
    
    /**
     * 获取所有舞蹈培训项目
     */
    @Override
    public List<DanceTraining> getAllDanceTraining() {
        
        return danceTrainingMapper.findAllDanceTraining();
    }

    /**
     * 后台获取培训项目
     */
    @Override
    public List<DanceTraining> getAllDanceTrainingByPage(Integer page, Integer limit) {
        List<DanceTraining> danceTrainings = null;
        if (page != null && limit != null) {
            danceTrainings = this.danceTrainingMapper.findAllDanceTrainingByPage(
                    Integer.valueOf((page.intValue() - 1) * limit.intValue()), limit);
        }
        return (danceTrainings != null) ? danceTrainings : null;
    }

    /**
     * 获取所有数量
     */
    @Override
    public Integer getDanceTrainingCount() {
        return danceTrainingMapper.getTrainingCount();
    }

    /**
     * 添加
     */
    @Override
    public Result addTraining(DanceTraining danceTraining) {
        if (danceTraining == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        danceTraining.setId(UUIDUtils.generateNumberUUID("DANCE_TRAINING_ID"));
        Integer row = danceTrainingMapper.creatTraining(danceTraining);
        return new Result(200,"添加成功!",row,danceTraining);
    }

    /**
     * 编辑
     */
    @Override
    public Result editTraining(DanceTraining danceTraining) {
        if (danceTraining == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        Integer row = danceTrainingMapper.updateTraining(danceTraining);
        return new Result(200,"修改成功!",row,danceTraining);
    }

    /**
     * 删除
     */
    @Override
    public Result delTraining(String id, HttpServletRequest request) {
        if(!StringUtils.isNotBlank(id)) {
            return new Result(-2,"数据有误!",0,null);
        }
        DanceTraining danceTraining = danceTrainingMapper.getTrainingById(id);
        if (danceTraining == null) {
            return new Result(-2,"数据有误!",0,null);
        }
        Integer row = danceTrainingMapper.deleteTraining(danceTraining.getId());
        String rootPath = request.getServletContext().getRealPath("/");
        FileUtils.deleteFile(rootPath + danceTraining.getDanceImg());
        return new Result(200,"删除成功!",row,id);
    }

    
	@Override
	public DanceTraining getDanceTraining(String id) {
		// TODO Auto-generated method stub
		return danceTrainingMapper.getTrainingById(id);
	}
    
    
    

}
