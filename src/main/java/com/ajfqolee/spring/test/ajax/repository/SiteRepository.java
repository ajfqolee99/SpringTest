package com.ajfqolee.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ajfqolee.spring.test.ajax.domain.Site;

@Mapper
public interface SiteRepository {
	
	public List<Site> selectSiteList();
	
}
