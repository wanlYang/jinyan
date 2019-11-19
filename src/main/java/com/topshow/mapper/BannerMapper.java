package com.topshow.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.topshow.entity.Banner;

@Repository
public interface BannerMapper {

	/**
	 * 获取banner
	 * @return 
	 */
	List<Banner> findAllBanner();

	Integer findAllBannerCount();

	Integer create(Banner banner);

	Integer del(Integer id);


}
