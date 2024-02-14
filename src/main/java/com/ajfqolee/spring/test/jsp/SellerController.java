package com.ajfqolee.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqolee.spring.test.jsp.domain.Seller;
import com.ajfqolee.spring.test.jsp.service.SellerService;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("profileImage") String profileImage
			,@RequestParam("temperature") double temperature
			) 
	{
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "입력성공 : " + count;
	}
	
	@PostMapping("/create/seller")
	public String createSellerByObject(
			@RequestParam("nickname") String nickname
			,@RequestParam("profileImage") String profileImage
			,@RequestParam("temperature") double temperature
			) 
	{
//		int count = sellerService.addSeller(nickname, profileImage, temperature);
		Seller seller = new Seller();
		seller.setNickname(nickname);
		seller.setProfileImage(profileImage);
		seller.setTemperature(temperature);
		
		int count = sellerService.addSellerByObject(seller);
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "jsp/seller-input";
	}
	
	@GetMapping("/info")
	// primitive type이면 null값을 받았을때 에러가 난다. 래퍼클래스로 변환 int -> Integer
	public String sellerInfo(Model model, @RequestParam(value = "id", required = false) Integer id) {
		Seller seller = null;
		// id가 전달되면 일치하는 판매자 정보
		if(id != null) {
			seller = sellerService.getSeller(id);
		} else {	// id가 전달되지 않으면 가장 최근 등록된 판매자 정보
			seller = sellerService.getLastSeller();
			
		}
		model.addAttribute("result", seller);
		return "jsp/sellerInfo";
	}	
	
}
