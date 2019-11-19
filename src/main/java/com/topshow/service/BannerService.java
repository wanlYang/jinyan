package com.topshow.service;

import java.util.List;

import com.topshow.entity.Banner;

public interface BannerService {

	/**
	 * 获取所有banner信息
	 * @return
	 */
	List<Banner> getAllBanner();

	/**
	 * 获取数量
	 * @return
	 */
	Integer getAllBannerCount();

	/**
	 * 上传Banner
	 * @param fileUrl
	 * @param fileUrl2
	 * @return
	 */
	Integer addBannerImg(Banner banner);

	/*
	 * 删除
	 */
	Integer del(Integer id);

	

}
