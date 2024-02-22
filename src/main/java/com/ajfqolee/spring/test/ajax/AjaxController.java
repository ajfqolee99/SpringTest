package com.ajfqolee.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.ajax.domain.Site;
import com.ajfqolee.spring.test.ajax.service.SiteService;

@Controller
@RequestMapping("/ajax/site")
public class AjaxController {
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping("/list")
	public String siteList(Model model) {
		List<Site> siteList = siteService.getSiteList();
		model.addAttribute("siteList", siteList);
		return "ajax/site/list";
	}
	
	// API 생성
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createSite(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) 
	{
		int count = siteService.addSite(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String siteInput() {
		return "ajax/site/input";
	}
	
	// 중복 url 확인 API
	@PostMapping("/dupUrl")
	@ResponseBody
	public Map<String, Boolean> isDupUrl(@RequestParam("url") String url) {
		boolean isDupUrl = siteService.isDupUrl(url);
		Map<String, Boolean> resultMap = new HashMap<>();
//		if(isDupUrl) {
//			resultMap.put("isDupUrl", true);
//		} else {
//			resultMap.put("isDupUrl", false);
//		}
		resultMap.put("isDupUrl", isDupUrl);
		return resultMap;
	}
	
	// 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteSite(@RequestParam("id") int id) {
		int count = siteService.deleteSite(id);
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
