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
	
	@RequestMapping("/insert/1")
	@ResponseBody
	public String createRealEstateByObject() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "입력성공 : " + count;
	}
	
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력성공 : " + count;
	}
	
	@RequestMapping("/update/1")
	@ResponseBody
	public String updateRealEstate() {
		// id가 26인 매물 정보에 type을 전세, 보증금 70000으로 변경
		int count = realEstateService.updateRealEstate(26, "전세", 70000);
		return "수정성공 : " + count;
	}
	
	@RequestMapping("/delete/1")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = realEstateService.deleteRealEstate(id);
		return "삭제성공 : " + count;
	}
	
	
	
}
