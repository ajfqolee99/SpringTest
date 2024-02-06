package com.ajfqolee.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.mybatis.domain.RealEstate;
import com.ajfqolee.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	@Autowired
	private RealEstateService realEstateRantService;
	
	@RequestMapping("/mybatis/real-estate/2")
	public RealEstate realEstateRant(@RequestParam("rent") int rent) {
		
		RealEstate realEstateRant = realEstateRantService.getRealEstateRant(rent);
		
		return realEstateRant;
		
	}
	
	
}
