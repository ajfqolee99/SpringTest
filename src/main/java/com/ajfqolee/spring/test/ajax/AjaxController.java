package com.ajfqolee.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	
}
