package com.ajfqolee.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqolee.spring.test.ajax.domain.Site;

@Mapper
public interface SiteRepository {
	
	public List<Site> selectSiteList();
	
	public int insertSite(@Param("name") String name, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteUrl(@Param("id") int id);
	
}
