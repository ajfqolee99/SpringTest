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
		List<Site> siteList = siteRepository.selectSiteList();
		return siteList;
	}
	
	public int addSite(String name, String url) {
		int count = siteRepository.insertSite(name, url);
		return count;
	}
	
	public boolean isDupUrl(String url) {
		int count = siteRepository.selectCountUrl(url);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int deleteSite(int id) {
		int count = siteRepository.deleteUrl(id);
		return count;
	}
	
	
}
