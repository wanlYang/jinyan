package com.topshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshow.entity.Banner;
import com.topshow.mapper.BannerMapper;
import com.topshow.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService{
	
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public List<Banner> getAllBanner() {
		
		return bannerMapper.findAllBanner();
	}

	@Override
	public Integer getAllBannerCount() {
		return bannerMapper.findAllBannerCount();
	}

	@Override
	public Integer addBannerImg(Banner banner) {
		// TODO Auto-generated method stub
		return bannerMapper.create(banner);
	}

	@Override
	public Integer del(Integer id) {
		// TODO Auto-generated method stub
		return bannerMapper.del(id);
	}
	
	

}
