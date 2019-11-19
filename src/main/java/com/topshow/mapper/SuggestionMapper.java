package com.topshow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.topshow.entity.Suggestion;

@Repository
public interface SuggestionMapper {

	Integer create(Suggestion suggestion);

	/**
	 * 获取所有留言
	 * @param valueOf
	 * @param limit
	 * @return
	 */
	List<Suggestion> findAllSuggestionByPage(@Param("start")Integer start, @Param("limit")Integer limit);

	/**
	 * 获取数量
	 * @return
	 */
	Integer findCount();

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer delete(String id);

}
