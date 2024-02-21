package com.ajfqolee.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqolee.spring.test.ajax.domain.Site;
import com.ajfqolee.spring.test.ajax.repository.SiteRepository;

@Service
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;
	
	public List<Site> getSiteList() {
		List<Site> site = siteRepository.selectSiteList();
		return site;
	}
	
	
	
}
