package com.ajfqolee.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.mybatis.domain.RealEstate;
import com.ajfqolee.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		// 파라미터로 전달된 id와 일치하는 매물정보를 json으로 response에 담는다
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> realEstateRent(@RequestParam("rent") int rent) {
		
		List<RealEstate> realEstateRentList = realEstateService.getRealEstateRent(rent);
		
		return realEstateRentList;
	}
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) 
	{
		List<RealEstate> realEstateAreaPrice = realEstateService.getRealEstateAreaPrice(area, price);
		
		return realEstateAreaPrice;
	}
	
	
}
